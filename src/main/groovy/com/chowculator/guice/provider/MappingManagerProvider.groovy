package com.chowculator.guice.provider

import com.chowculator.cassandraschema.connection.Connector
import com.datastax.driver.mapping.MappingManager
import com.google.inject.Inject
import com.google.inject.Provider

class MappingManagerProvider implements Provider<MappingManager> {
    private final Connector connector

    @Inject
    public MappingManagerProvider(Connector connector) {
        this.connector = connector;
    }

    @Override
    MappingManager get() {
        return new MappingManager(connector.session)
    }
}
