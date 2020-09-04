package com.companion.tasks

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(
		exclude = [
			DataSourceAutoConfiguration::class,
			DataSourceTransactionManagerAutoConfiguration::class,
			HibernateJpaAutoConfiguration::class
		]
)
class TasksServiceApplication

fun main(args: Array<String>) {
	runApplication<TasksServiceApplication>(*args)
}
