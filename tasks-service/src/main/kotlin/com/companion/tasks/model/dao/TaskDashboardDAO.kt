package com.companion.tasks.model.dao

import com.companion.tasks.model.entity.TaskDashboardEntity
import com.companion.tasks.util.BasicDAO
import org.springframework.stereotype.Repository

/**
 * @author Vladislav Marchenko
 */
@Repository
class TaskDashboardDAO : BasicDAO<TaskDashboardEntity, Long>(clazz = TaskDashboardEntity::class.java){

}