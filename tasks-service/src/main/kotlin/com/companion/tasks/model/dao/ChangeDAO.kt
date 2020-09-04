package com.companion.tasks.model.dao

import com.companion.tasks.model.entity.ChangeEntity
import com.companion.tasks.util.BasicDAO
import org.springframework.stereotype.Repository

/**
 * @author Vladislav Marchenko
 */
@Repository
class ChangeDAO : BasicDAO<ChangeEntity, Long>(clazz = ChangeEntity::class.java) {

}