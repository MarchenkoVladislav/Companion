package com.companion.tasks.model.entity

import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_to_user_links")
class TaskToUserLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_to_user_link_id")
    var taskToUserLinkId : Long? = 0

    @Column(name = "task_id", nullable = false)
    var taskId : Long? = null

    @Column(name = "user_id", nullable = false)
    var userId : Long? = null
}