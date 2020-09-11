package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "commentaries")
class CommentaryEntity (
        @Column(name = "text", columnDefinition = "text", nullable = false)
        var text : String? = null,

        @Column(name = "user_id", nullable = false)
        var userId : Long? = null,

        @Column(name = "task_id", nullable = false)
        var taskId : Long? = null,

        @Column(name = "date", columnDefinition = "timestamp", nullable = false)
        val date : Date = Date(),

        @OneToMany(
            mappedBy = "commentaryId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
        )
        @JsonIgnore
        var commentaryAttachmentEntityEntities : Set<CommentaryAttachmentEntity> = setOf()
) : AbstractEntity<Long>()