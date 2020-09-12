package com.companion.common.service.impl

import com.companion.common.model.dao.AbstractDAO
import com.companion.common.model.entity.AbstractEntity
import com.companion.common.service.GenericService
import org.springframework.beans.factory.annotation.Autowired
import java.io.Serializable

/**
 * @author Vladislav Marchenko
 * @author shvatov
 */
abstract class AbstractGenericServiceImpl<T, ID, D> : GenericService<T, ID>
    where T : AbstractEntity<ID>,
          ID : Serializable,
          D : AbstractDAO<T, ID> {

    @Autowired
    protected lateinit var dao: D

    override fun find(id: ID) = dao.findById(id)

    override fun findAll() = dao.findAll()

    override fun save(entity: T) = dao.save(entity).let { dao.findById(it)!! }

    override fun delete(entity: T) {
        dao.delete(entity)
    }

    override fun delete(id: ID) {
        dao.findById(id)?.also {
            dao.delete(it)
        }
    }
}