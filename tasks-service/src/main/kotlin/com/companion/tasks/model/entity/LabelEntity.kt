package com.companion.tasks.model.entity

import com.fasterxml.jackson.annotation.JsonIgnore
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "labels")
class LabelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "label_id")
    var labelId : Long? = 0

    @Column(name = "color", columnDefinition = "character varying(8)", nullable = false)
    var color : String? = null

    @Column(name = "text", columnDefinition = "character varying(20)", nullable = false)
    var text : String? = null

    @Column(name = "task_dashboard_id", nullable = false)
    var taskDashboardId : Long? = null

    @OneToMany(
            mappedBy = "labelId",
            fetch = FetchType.LAZY,
            cascade = [CascadeType.ALL]
    )
    @JsonIgnore
    var labelToTaskLinkEntities : Set<LabelToTaskLinkEntity> = setOf()
}