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
@Table(name = "task_attachments")
class TaskAttachmentEntity(
        @Column(name = "task_id", nullable = false)
        var taskId : Long? = null,

        @Column(name = "link", columnDefinition = "text", nullable = false)
        var link : String? = null,

        @Column(name = "header", columnDefinition = "text", nullable = true)
        var header : String? = null,

        @Column(name = "created_date", columnDefinition = "timestamp", nullable = false)
        val createdDate : Date = Date()
) : AbstractEntity<Long>()