package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_dashboard_to_user_links")
class TaskDashboardToUserLinkEntity(
        @Column(name = "task_dashboard_id", nullable = false)
        var taskDashboardId : Long? = null,

        @Column(name = "user_id", nullable = false)
        var userId : Long? = null
) : AbstractEntity<Long>()