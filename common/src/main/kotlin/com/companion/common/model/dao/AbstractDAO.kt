package com.companion.common.model.dao

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import java.io.Serializable
import kotlin.streams.toList


/**
 * @author Vladislav Marchenko
 */
@Repository
abstract class AbstractDAO<T: Serializable, ID>  {

    private val clazz: String = this::class.simpleName!!

    @Autowired
    lateinit var sessionFactory: SessionFactory

    @Suppress("UNCHECKED_CAST")
    fun findById(id: ID) : T? = sessionFactory.currentSession
            ?.createQuery("From " + clazz + " where " + convertClassNameToIdName(clazz) + " = :id")
            ?.list()
            ?.get(0) as T?

    @Suppress("UNCHECKED_CAST")
    fun findAll() : List<T> = sessionFactory
            .currentSession?.createQuery("From $clazz")
            ?.list() as List<T>

    open fun delete(obj: T) : Unit? = sessionFactory.currentSession?.delete(obj)

    @Suppress("UNCHECKED_CAST")
    open fun save(obj: T) : T? = sessionFactory.currentSession?.save(obj) as T?

    open fun update(obj: T) : Unit? = sessionFactory.currentSession?.update(obj)
    
    private fun convertClassNameToIdName(className : String) : String {
        var res = className.replace("Entity", "_id")

        var myMap = mutableMapOf<String, String>()

        res.chars()
                .filter { it.toChar().isUpperCase() }
                .toList()
                .map{myMap[it.toChar().toString()] = "_" + it.toChar().toString().toLowerCase()}

        myMap.forEach{ (t, u) -> res = res.replace(t, u) }

        return res.removePrefix("_")
    }

}





