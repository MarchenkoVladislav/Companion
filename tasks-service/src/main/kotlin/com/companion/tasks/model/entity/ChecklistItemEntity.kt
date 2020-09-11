package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "checklist_items")
class ChecklistItemEntity(
        @Column(name = "text", columnDefinition = "text", nullable = false)
        var text : String? = null,

        @Column(name = "is_completed", columnDefinition = "boolean", nullable = false)
        var isCompleted : Boolean = false,

        @Column(name = "checklist_id", nullable = false)
        var checklistId : Long? = null
) : AbstractEntity<Long>()


