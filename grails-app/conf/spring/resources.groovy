import multitenancy.SwitchableDataSource
import org.springframework.jdbc.datasource.DriverManagerDataSource
import multitenancy.Environment

beans = {
    parentDataSource(DriverManagerDataSource) {
        bean -> bean.'abstract' = true;
            driverClassName = 'com.mysql.jdbc.Driver'
            username = "root"
    }

    Environment.list().each { env ->
        "${env.prefix}DataSource"(DriverManagerDataSource) {bean ->
            bean.parent = parentDataSource
            bean.scope = 'prototype'
            def port = env.port ?: 3306
            url = "jdbc:mysql://${env.host}:${port}/${env.name}"
            println url
            if (env.user) {
                username = env.user
            }
            if (env.password) {
                password = env.password
            }
        }
    }

    def dataSources = [:]
    Environment.list().each {env ->
        dataSources[env.id] = ref(env.prefix + 'DataSource')
    }

    dataSource(SwitchableDataSource) {
        targetDataSources = dataSources
    }

}
