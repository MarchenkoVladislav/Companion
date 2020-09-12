package com.companion.common.service

import com.companion.common.model.entity.AbstractEntity
import java.io.Serializable

/**
 * @author shvatov
 */
interface GenericService<T : AbstractEntity<ID>, ID : Serializable> {
    fun find(id: ID): T?

    fun findAll(): List<T>

    fun save(entity: T): T

    fun delete(entity: T)

    fun delete(id: ID)
}