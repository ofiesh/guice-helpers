package com.chowculator.guice.provider

import com.chowculator.cassandraschema.connection.Connector
import com.datastax.driver.mapping.MappingManager
import com.google.inject.Provider
import com.google.inject.TypeLiteral

import javax.inject.Inject

class AccessorProvider<T> implements Provider<T> {
    private final MappingManager mappingManager
    private final TypeLiteral<T> typeLiteral

    @Inject
    AccessorProvider(MappingManager mappingManager, TypeLiteral<T> typeLiteral) {
        this.mappingManager = mappingManager
        this.typeLiteral = typeLiteral
    }

    @Override
    T get() {
        mappingManager.createAccessor(typeLiteral.getRawType() as Class<T>)
    }
}
