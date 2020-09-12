package com.companion.common.model.vo

import java.io.Serializable

/**
 * @author shvatov
 */
abstract class AbstractVo<ID : Serializable> constructor(var id: ID) : Serializable