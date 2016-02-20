package com.chowculator.guice.provider

import com.datastax.driver.mapping.Mapper
import com.datastax.driver.mapping.MappingManager
import com.google.inject.Inject
import com.google.inject.Provider
import com.google.inject.TypeLiteral

class MapperProvider<T> implements Provider<Mapper<T>> {
    private final MappingManager mappingManager;
    private final TypeLiteral<T> typeLiteral;

    @Inject
    MapperProvider(MappingManager mappingManager, TypeLiteral<T> typeLiteral) {
        this.mappingManager = mappingManager
        this.typeLiteral = typeLiteral
    }

    @Override
    Mapper<? super T> get() {
        mappingManager.mapper(typeLiteral.getRawType())
    }
}
