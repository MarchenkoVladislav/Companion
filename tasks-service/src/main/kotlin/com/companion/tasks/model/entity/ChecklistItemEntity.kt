package com.companion.tasks.model.entity

import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "checklist_items")
class ChecklistItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "checklist_item_id")
    var checklistItemId : Long? = 0

    @Column(name = "text", columnDefinition = "text", nullable = false)
    var text : String? = null

    @Column(name = "is_completed", columnDefinition = "boolean", nullable = false)
    var isCompleted : Boolean = false

    @Column(name = "checklist_id", nullable = false)
    var checklistId : Long? = null
}