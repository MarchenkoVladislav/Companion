package com.companion.tasks.model.entity

import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_dashboard_to_user_links")
class TaskDashboardToUserLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_dashboard_to_user_id")
    var taskDashboardToUserLinkId : Long? = 0

    @Column(name = "task_dashboard_id", nullable = false)
    var taskDashboardId : Long? = null

    @Column(name = "user_id", nullable = false)
    var userId : Long? = null
}