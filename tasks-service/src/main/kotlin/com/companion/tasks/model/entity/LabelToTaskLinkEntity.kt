package com.companion.tasks.model.entity

import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "label_to_task_links")
class LabelToTaskLinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_to_task_link_id")
    var labelToTaskLinkId : Long? = 0

    @Column(name = "label_id", nullable = false)
    var labelId : Long? = null

    @Column(name = "task_id", nullable = false)
    var taskId : Long? = null
}