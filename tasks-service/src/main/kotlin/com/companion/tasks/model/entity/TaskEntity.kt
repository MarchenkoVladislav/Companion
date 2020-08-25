package com.companion.tasks.model.entity

import com.companion.tasks.model.enums.TaskPriority
import com.companion.tasks.model.enums.TaskStatus
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table (name = "tasks")
class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_id")
    var taskId : Long? = 0

    @Column(name = "description", columnDefinition = "text", nullable = false)
    var description : String? = null

    @Column(name = "due_date", columnDefinition = "timestamp")
    var dueDate : Date? = null

    @Column(name = "task_list_id", nullable = false)
    var taskListId : Long? = null

    @Column(name = "task_status", columnDefinition = "character varying(14)", nullable = false)
    @Enumerated(EnumType.STRING)
    var taskStatus : TaskStatus = TaskStatus.NOT_COMPLETED

    @Column(name = "task_priority", columnDefinition = "character varying(7)")
    @Enumerated(EnumType.STRING)
    var taskPriority : TaskPriority? = null

    @OneToMany(
            mappedBy = "taskId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var labelToTaskLinkEntities : Set<LabelToTaskLinkEntity> = setOf()

    @OneToMany(
            mappedBy = "taskId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var taskToUserLinkEntities : Set<TaskToUserLinkEntity> = setOf()

    @OneToMany(
            mappedBy = "taskId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var commentaryEntities : Set<CommentaryEntity> = setOf()

    @OneToMany(
            mappedBy = "taskId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var checklistEntities : Set<ChecklistEntity> = setOf()

    @OneToMany(
            mappedBy = "taskId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var taskAttachmentEntities : Set<TaskAttachmentEntity> = setOf()


}