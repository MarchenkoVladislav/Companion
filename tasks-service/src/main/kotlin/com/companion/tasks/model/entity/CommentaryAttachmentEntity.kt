package com.companion.tasks.model.entity

import java.util.*
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "commentary_attachments")
class CommentaryAttachmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_attachment_id")
    var commentaryAttachmentId : Long? = 0

    @Column(name = "commentary_id", nullable = false)
    var commentaryId : Long? = null

    @Column(name = "link", columnDefinition = "text", nullable = false)
    var link : String? = null

    @Column(name = "header", columnDefinition = "text", nullable = true)
    var header : String? = null

    @Column(name = "created_date", columnDefinition = "timestamp", nullable = false)
    val createdDate : Date = Date()
}