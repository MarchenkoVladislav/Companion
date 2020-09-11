package com.companion.tasks.model.dao

import com.companion.common.model.dao.AbstractDAO
import com.companion.tasks.model.entity.TaskListEntity
import org.springframework.stereotype.Repository

/**
 * @author Vladislav Marchenko
 */
@Repository
class TaskListDAO : AbstractDAO<TaskListEntity, Long>()