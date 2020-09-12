package com.companion.common.utils

import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

/**
 * @author shvatov
 */
@Suppress("unchecked_cast")
fun <T> getGenericClass(cls: KClass<*>, genericIndex: Int): Class<T> {
    val typeArguments = (cls.java.genericSuperclass as ParameterizedType).actualTypeArguments
    return if (genericIndex !in typeArguments.indices) {
        throw IllegalArgumentException("'genericIndex' out of bounds - " +
            "expected in range ${typeArguments.indices}, actual - $genericIndex")
    } else typeArguments[genericIndex] as Class<T>
}