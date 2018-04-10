package multitenancy

import multitenancy.Environment

class DataSourceFilters {
    def filters = {
        all(uri: '/**') {
            before = {
                if (!session.environment) {
                    session.environment = Environment.list()[0]
                }
                EnvironmentHolder.setEnvironment(session.environment)
            }
        }
    }
}
