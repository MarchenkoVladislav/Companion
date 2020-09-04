package com.companion.tasks.model.entity

import java.util.*
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

    @Column(name = "header", columnDefinition = "text", nullable = true)
    var header : String? = null

    @Column(name = "created_date", columnDefinition = "timestamp", nullable = false)
    val createdDate : Date = Date()
}