package com.companion.common.model.entity

import java.io.Serializable
import javax.persistence.*

/**
 * @author Vladislav Marchenko
 */
@MappedSuperclass
abstract class AbstractEntity<T : Serializable> : Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: T? = null
}