package multitenancy
/**
 * Created by leandro on 21/03/18.
 */
class Environment {

    static environments = []

    static {
        environments << [id: 1, name: 'primarydb', prefix: 'primary',
                         host: 'localhost', user:'root', password: '123456']
        environments << [id: 2, name: 'secondarydb', prefix: 'secondary',
                         host: 'localhost', user:'root', password: '123456']
        /*environments << [id: 2, name: 'UAT', prefix: 'uat',
                         host: 'localhost']*/
        /*environments << [id: 5, name: 'Prod', prefix: 'prod',
                         host: 'localhost', user:'grails',
                         port: 13306,
                         passwordRequired: true]
*/
        //unique id check
        environments.each {env ->
            assert environments
                    .findAll {it.id == env.id}.size() == 1}
    }

    static list() {
        return environments
    }

}
