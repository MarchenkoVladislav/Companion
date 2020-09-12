package com.companion.common.model.dao

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.io.Serializable
import kotlin.streams.toList


/**
 * @author Vladislav Marchenko
 */
@Suppress("UNCHECKED_CAST")
abstract class AbstractDAO<T: Serializable, ID>  {

    protected val clazz: Class<T> = (this::class.java.genericSuperclass as java.lang.reflect.ParameterizedType).actualTypeArguments[0] as Class<T>

    @Autowired
    lateinit var sessionFactory: SessionFactory

    fun findById(id: ID) : T? = sessionFactory.currentSession
            ?.createQuery("From ${clazz.name} where id = :id")
            ?.setParameter("id", id)
            ?.list()
            ?.get(0) as T?

    fun findAll() : List<T> = sessionFactory
            .currentSession?.createQuery("From ${clazz.name}")
            ?.list() as List<T>

    open fun delete(obj: T) : Unit? = sessionFactory.currentSession?.delete(obj)

    open fun saveOrUpdate(obj: T) : T? = sessionFactory.currentSession?.saveOrUpdate(obj) as T?

}





