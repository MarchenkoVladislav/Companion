package com.companion.tasks.model.entity

import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_attachments")
class TaskAttachmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_attachment_id")
    var taskAttachmentId : Long? = 0

    @Column(name = "task_id", nullable = false)
    var taskId : Long? = null

    @Column(name = "link", columnDefinition = "text", nullable = false)
    var link : String? = null
}