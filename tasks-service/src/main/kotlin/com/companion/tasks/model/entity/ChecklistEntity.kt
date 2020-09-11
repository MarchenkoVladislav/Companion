package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "checklists")
class ChecklistEntity(
        @Column(name = "task_id", nullable = false)
        var taskId : Long? = null,

        @OneToMany(
            mappedBy = "checklistId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
        )
        @JsonIgnore
        var checklistItemEntities : Set<ChecklistItemEntity> = setOf()
) : AbstractEntity<Long>()