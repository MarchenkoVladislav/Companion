package com.companion.common.model.dao

import com.companion.common.model.entity.AbstractEntity
import com.companion.common.utils.getGenericClass
import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import java.io.Serializable


/**
 * @author Vladislav Marchenko
 */
@Suppress("UNCHECKED_CAST")
abstract class AbstractDAO<T : AbstractEntity<ID>, ID : Serializable> {
    protected val clazz: Class<T> = getGenericClass(this::class, 0)

    @Autowired
    private lateinit var sessionFactory: SessionFactory

    fun findById(id: ID) = sessionFactory
        .currentSession
        .createQuery("From ${clazz.name} where id = :id")
        .setParameter("id", id)
        .list()[0] as? T

    fun findAll() = sessionFactory
        .currentSession
        .createQuery("From ${clazz.name}")
        .list() as List<T>

    open fun delete(obj: T) {
        sessionFactory.currentSession.delete(obj)
    }

    open fun save(obj: T) = sessionFactory
        .currentSession
        .save(obj) as ID
}





