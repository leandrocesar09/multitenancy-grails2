package multitenancy

import org.codehaus.groovy.grails.commons.ApplicationAttributes
import org.codehaus.groovy.grails.web.context.ServletContextHolder

import javax.transaction.Transactional

@Transactional
class EnvironmentController {

    def index() {
        redirect(uri:'/')
    }

    def changeDatasource(){
        def envOld = EnvironmentHolder.getEnvironment()
        def newId = 1
        if (envOld.id == 1)
            newId = 2

        def env = Environment.list().find {it.id == new Integer(newId)}
        if (env){
            EnvironmentHolder.setEnvironment env

            //test connection
            def ds = getDataSourceForEnv()
            def con = ds.getConnection()

            //set environment
            session.environment = env
        }
        redirect(uri:'/')
    }

    private def getDataSourceForEnv() {
        def servletContext = ServletContextHolder.servletContext
        def ctx = servletContext.getAttribute(ApplicationAttributes.APPLICATION_CONTEXT)
        return ctx.dataSource
    }

}
