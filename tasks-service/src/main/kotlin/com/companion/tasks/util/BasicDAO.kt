package com.companion.tasks.util

import org.hibernate.SessionFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.transaction.annotation.Transactional
import java.io.Serializable
import kotlin.streams.toList


/**
 * @author Vladislav Marchenko
 */
@Transactional
class BasicDAO<T, ID>(var clazz: Class<T>)  {

    @Autowired
    private var sessionFactory: SessionFactory? = null

    fun findById(id: ID) : T? = sessionFactory?.currentSession
            ?.createQuery("From " + clazz.name + " where " + convertClassNameToIdName(clazz.name) + " = :id")
            ?.list()
            ?.get(0) as T?

    fun findAll() : List<T> = sessionFactory
            ?.currentSession?.createQuery("From " + clazz.name.toString())
            ?.list() as List<T>

    fun delete(obj: T) : Unit? = sessionFactory?.currentSession?.delete(obj)

    fun save(obj: T) : Serializable? = sessionFactory?.currentSession?.save(obj)

    fun update(obj: T) : Unit? = sessionFactory?.currentSession?.update(obj)
    
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




