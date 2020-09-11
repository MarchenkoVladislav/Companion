package com.companion.tasks.model.entity

import com.companion.common.model.entity.AbstractEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

/**
 * @author Vladislav Marchenko
 */
@Entity
@Table(name = "task_to_user_links")
class TaskToUserLinkEntity(
        @Column(name = "task_id", nullable = false)
        var taskId : Long? = null,

        @Column(name = "user_id", nullable = false)
        var userId : Long? = null
) : AbstractEntity<Long>()