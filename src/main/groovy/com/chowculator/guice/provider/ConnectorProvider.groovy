package com.chowculator.guice.provider

import com.chowculator.cassandraschema.connection.Connector
import com.chowculator.cassandraschema.connection.ConnectorConfig
import com.google.inject.Inject
import com.google.inject.Provider

class ConnectorProvider implements Provider<Connector> {
    private final ConnectorConfig config

    @Inject
    ConnectorProvider(ConnectorConfig config) {
        this.config = config
    }

    @Override
    Connector get() {
        new Connector(config)
    }
}
