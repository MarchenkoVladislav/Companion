package com.companion.tasks.model.dao

import com.companion.tasks.model.entity.TaskDashboardEntity
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit4.SpringRunner
import javax.transaction.Transactional

@RunWith(SpringRunner::class)
@TestPropertySource(locations= ["classpath:application-test.properties"])
@SpringBootTest
internal class DAOTest {

    @Autowired
    lateinit var taskDashboardDAO: TaskDashboardDAO

    @Test
    @Transactional
    fun test() {
        val tde = TaskDashboardEntity("name", 1)

        taskDashboardDAO.saveOrUpdate(tde)

        println(taskDashboardDAO.findAll())
    }
}