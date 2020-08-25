package com.companion.tasks.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "commentaries")
class CommentaryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentary_id")
    var commentaryId : Long? = 0

    @Column(name = "text", columnDefinition = "text", nullable = false)
    var text : String? = null

    @Column(name = "user_id", nullable = false)
    var userId : Long? = null

    @Column(name = "task_id", nullable = false)
    var taskId : Long? = null

    @Column(name = "date", columnDefinition = "timestamp", nullable = false)
    val date : Date = Date()

    @OneToMany(
            mappedBy = "commentaryId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var commentaryAttachmentEntityEntities : Set<CommentaryAttachmentEntity> = setOf()
}