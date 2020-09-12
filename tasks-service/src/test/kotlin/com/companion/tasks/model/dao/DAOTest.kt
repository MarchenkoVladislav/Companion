package com.companion.tasks.model.dao

import com.companion.tasks.model.entity.TaskDashboardEntity
import org.junit.Assert
import org.junit.Before
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
import java.util.stream.LongStream
import javax.transaction.Transactional

@RunWith(SpringRunner::class)
@TestPropertySource(locations= ["classpath:application-test.properties"])
@SpringBootTest
internal class DAOTest {

    private val entityCount = 10L

    @Autowired
    lateinit var taskDashboardDAO: TaskDashboardDAO

    @Before
    @Transactional
    fun setUp() = LongStream.rangeClosed(1, entityCount).forEach{taskDashboardDAO.saveOrUpdate(TaskDashboardEntity("name$it", it))}

    @Test
    @Transactional
    fun test() {
        Assert.assertEquals(taskDashboardDAO.findAll().size.toLong(), entityCount)
    }
}