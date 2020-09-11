package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import com.fasterxml.jackson.annotation.JsonIgnore
import java.util.*
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_dashboards")
class TaskDashboardEntity(
        @Column(name = "name", columnDefinition = "character varying(50)", nullable = false)
        var name : String? = null,

        @Column(name = "creator_id", nullable = false)
        var creatorId : Long? = null,

        @Column(name = "created_date", columnDefinition = "timestamp", nullable = false)
        val createdDate : Date = Date(),

        @OneToMany(
            mappedBy = "taskDashboardId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
        )
        @JsonIgnore
        var changeEntities : Set<ChangeEntity> = setOf(),

        @OneToMany(
            mappedBy = "taskDashboardId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
        )
        @JsonIgnore
        var taskDashboardToUserLinkEntities : Set<TaskDashboardToUserLinkEntity> = setOf(),

        @OneToMany(
            mappedBy = "taskDashboardId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
        )
        @JsonIgnore
        var labelEntities : Set<LabelEntity> = setOf(),

        @OneToMany(
            mappedBy = "taskDashboardId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
        )
        @JsonIgnore
        var taskListEntities : Set<TaskListEntity> = setOf()
) : AbstractEntity<Long>()