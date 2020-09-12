package com.companion.common.model.mapper.impl

import com.companion.common.model.entity.AbstractEntity
import com.companion.common.model.mapper.GenericMapper
import com.companion.common.model.vo.AbstractVo
import com.companion.common.utils.getGenericClass
import org.modelmapper.Converter
import org.modelmapper.ModelMapper
import org.springframework.beans.factory.annotation.Autowired
import java.io.Serializable


/**
 * @author shvatov
 */
abstract class AbstractGenericMapperImpl<E, V, ID> : GenericMapper<E, V, ID>
    where E : AbstractEntity<ID>,
          V : AbstractVo<ID>,
          ID : Serializable {

    @Autowired
    private lateinit var modelMapper: ModelMapper

    private val entityClass: Class<E> = getGenericClass(this::class, 0)

    private val voClass: Class<V> = getGenericClass(this::class, 1)

    override fun toEntity(vo: V?) = vo?.let {
        modelMapper.map(vo, entityClass)
    }

    override fun toVo(entity: E?) = entity?.let {
        modelMapper.map(entity, voClass)
    }

    protected fun toVoConverter() = Converter<E, V> {
        mapSpecificFields(it.source, it.destination)
        it.destination
    }

    protected fun toEntityConverter() = Converter<V, E> {
        mapSpecificFields(it.source, it.destination)
        it.destination
    }

    abstract fun setupMapper()

    protected abstract fun mapSpecificFields(source: E, destination: V)

    protected abstract fun mapSpecificFields(source: V, destination: E)
}