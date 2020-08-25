package com.companion.tasks.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_lists")
class TaskListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "task_list_id")
    var taskListId : Long? = 0

    @Column(name = "name", columnDefinition = "character varying(50)", nullable = false)
    var name : String? = null

    @Column(name = "task_dashboard_id", nullable = false)
    var taskDashboardId : Long? = null

    @OneToMany(
            mappedBy = "taskListId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var taskEntities : Set<TaskEntity> = setOf()
}