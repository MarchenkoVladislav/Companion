package com.companion.tasks.model.entity

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
}