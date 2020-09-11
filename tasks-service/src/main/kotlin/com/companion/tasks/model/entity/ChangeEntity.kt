package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "changes")
class ChangeEntity(
        @Column(name = "text", columnDefinition = "text", nullable = false)
        var text : String? = null,

        @Column(name = "user_id", nullable = false)
        var userId : Long? = null,

        @Column(name = "task_dashboard_id", nullable = false)
        var taskDashboardId : Long? = null,

        @Column(name = "date", columnDefinition = "timestamp", nullable = false)
        val date : Date = Date()
) : AbstractEntity<Long>()


