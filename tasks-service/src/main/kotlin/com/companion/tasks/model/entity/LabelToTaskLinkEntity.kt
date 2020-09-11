package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "label_to_task_links")
class LabelToTaskLinkEntity(
        @Column(name = "label_id", nullable = false)
        var labelId : Long? = null,

        @Column(name = "task_id", nullable = false)
        var taskId : Long? = null
) : AbstractEntity<Long>()