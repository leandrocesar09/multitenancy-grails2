package multitenancy

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource

import javax.sql.DataSource

class SwitchableDataSource extends AbstractRoutingDataSource
        implements ApplicationContextAware {

    def applicationContext

    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext
    }

    protected DataSource determineTargetDataSource() {
        DriverManagerDataSource ds = super.determineTargetDataSource();
        def env = EnvironmentHolder.getEnvironment()

        if (env && env.passwordRequired && ds) {
            ds.setPassword(env.password)
        }
        return ds
    }

    protected Object determineCurrentLookupKey() {
        def env = EnvironmentHolder.getEnvironment()
        return env?.id ?: Environment.list()[0]?.id
    }


}
