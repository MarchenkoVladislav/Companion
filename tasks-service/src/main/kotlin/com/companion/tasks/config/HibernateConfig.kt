package com.companion.tasks.config

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import java.util.*
import javax.sql.DataSource


/**
 * @author Vladislav Marchenko
 */
@Configuration
class HibernateConfig {
    @Autowired
    private val env: Environment? = null

    @Bean(name = ["dataSource"])
    fun getDataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()

        dataSource.setDriverClassName(env!!.getProperty("spring.datasource.driver-class-name")!!)
        dataSource.url = env.getProperty("spring.datasource.url")
        dataSource.username = env.getProperty("spring.datasource.username")
        dataSource.password = env.getProperty("spring.datasource.password")

        return dataSource
    }

    @Autowired
    @Bean(name = ["sessionFactory"])
    @Throws(Exception::class)
    fun getSessionFactory(dataSource: DataSource?): SessionFactory? {
        val properties = Properties()

        properties["hibernate.dialect"] = env!!.getProperty("spring.jpa.properties.hibernate.dialect")
        properties["hibernate.show_sql"] = env.getProperty("spring.jpa.show-sql")
        properties["current_session_context_class"] = env.getProperty("spring.jpa.properties.hibernate.current_session_context_class")
        properties["hibernate.temp.use_jdbc_metadata_defaults"] = false;

        val factoryBean = LocalSessionFactoryBean()

        factoryBean.setPackagesToScan(*arrayOf("com.companion.tasks.model.entity"))
        factoryBean.setDataSource(dataSource!!)
        factoryBean.hibernateProperties = properties
        factoryBean.afterPropertiesSet()

        return factoryBean.getObject()
    }

    @Autowired
    @Bean(name = ["transactionManager"])
    fun getTransactionManager(sessionFactory: SessionFactory?): HibernateTransactionManager? {
        return HibernateTransactionManager(sessionFactory!!)
    }
}