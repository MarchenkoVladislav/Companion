package com.companion.common.model.mapper

import com.companion.common.model.entity.AbstractEntity
import com.companion.common.model.vo.AbstractVo
import java.io.Serializable

/**
 * @author shvatov
 */
interface GenericMapper<E, V, ID> where E : AbstractEntity<ID>,
                                        V : AbstractVo<ID>,
                                        ID : Serializable {
    fun toEntity(vo: V?): E?

    fun toVo(entity: E?): V?
}