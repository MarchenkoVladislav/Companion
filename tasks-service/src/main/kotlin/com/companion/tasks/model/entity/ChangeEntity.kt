package com.companion.tasks.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "changes")
class ChangeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "change_id")
    var changeId : Long? = 0

    @Column(name = "text", columnDefinition = "text", nullable = false)
    var text : String? = null

    @Column(name = "user_id", nullable = false)
    var userId : Long? = null

    @Column(name = "task_dashboard_id", nullable = false)
    var taskDashboardId : Long? = null

    @Column(name = "date", columnDefinition = "timestamp", nullable = false)
    var date : Date = Date()

}