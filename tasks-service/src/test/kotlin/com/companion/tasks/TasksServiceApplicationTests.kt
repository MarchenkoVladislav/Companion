package com.companion.tasks

import com.companion.tasks.model.dao.TaskDashboardDAO
import com.companion.tasks.model.entity.TaskDashboardEntity
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TasksServiceApplicationTests {

	@Test
	fun contextLoads() {
		var td = TaskDashboardEntity()
		td.name = "hdjjd"
		td.creatorId = 1
		var tdd = TaskDashboardDAO()
		println(tdd.save(td))

	}

}
