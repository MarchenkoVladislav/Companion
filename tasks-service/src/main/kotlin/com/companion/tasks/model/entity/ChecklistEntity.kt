package com.companion.tasks.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "checklists")
class ChecklistEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_id")
    var checklistId : Long? = 0

    @Column(name = "task_id", nullable = false)
    var taskId : Long? = null

    @OneToMany(
            mappedBy = "checklistId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var checklistItemEntities : Set<ChecklistItemEntity> = setOf()
}