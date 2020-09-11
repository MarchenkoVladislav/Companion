package com.companion.tasks.model.dao

import com.companion.common.model.dao.AbstractDAO
import com.companion.tasks.model.entity.TaskAttachmentEntity
import org.springframework.stereotype.Repository

/**
 * @author Vladislav Marchenko
 */
@Repository
class TaskAttachmentDAO : AbstractDAO<TaskAttachmentEntity, Long>()