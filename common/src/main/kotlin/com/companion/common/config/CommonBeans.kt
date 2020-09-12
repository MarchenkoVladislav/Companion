package com.companion.common.config

import org.modelmapper.ModelMapper
import org.modelmapper.config.Configuration.AccessLevel
import org.modelmapper.convention.MatchingStrategies
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * @author shvatov
 */
@Configuration
class CommonBeans {
    // TODO: move data source config here

    @Bean
    fun modelMapper() = ModelMapper().also {
        it.configuration.apply {
            matchingStrategy = MatchingStrategies.STRICT
            isFieldMatchingEnabled = true
            isSkipNullEnabled = true
            fieldAccessLevel = AccessLevel.PRIVATE
        }
    }
}