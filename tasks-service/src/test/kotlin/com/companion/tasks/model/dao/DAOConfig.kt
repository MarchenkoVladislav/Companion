package com.companion.tasks.model.dao

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.core.env.Environment
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import java.util.*
import javax.sql.DataSource

@ComponentScan("com.companion")
@TestConfiguration
class DAOConfig {
    @Autowired
    private lateinit var env: Environment

    @Bean(name = ["dataSource"])
    fun getDataSource(): DataSource? {
        val dataSource = DriverManagerDataSource()

        dataSource.setDriverClassName(env.getProperty("spring.datasource.driver-class-name")!!)
        dataSource.url = env.getProperty("spring.liquibase.url")
        dataSource.username = env.getProperty("spring.liquibase.username")
        dataSource.password = env.getProperty("spring.liquibase.password")

        return dataSource
    }

    @Bean(name = ["sessionFactory"])
    @Throws(Exception::class)
    fun getSessionFactory(dataSource: DataSource?): SessionFactory? {
        val properties = Properties()

        properties["hibernate.dialect"] = env.getProperty("spring.jpa.properties.hibernate.dialect")
        properties["hibernate.show_sql"] = env.getProperty("spring.jpa.show-sql")
        properties["hibernate.temp.use_jdbc_metadata_defaults"] = false;

        val factoryBean = LocalSessionFactoryBean()

        factoryBean.setPackagesToScan(*arrayOf("com.companion.tasks.model.entity"))
        factoryBean.setDataSource(dataSource!!)
        factoryBean.hibernateProperties = properties
        factoryBean.afterPropertiesSet()

        return factoryBean.getObject()
    }

    @Bean(name = ["transactionManager"])
    fun getTransactionManager(sessionFactory: SessionFactory?): HibernateTransactionManager? {
        return HibernateTransactionManager(sessionFactory!!)
    }

    @Bean
    fun get() : TaskDashboardDAO = TaskDashboardDAO()
}