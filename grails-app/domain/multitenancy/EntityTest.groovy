package multitenancy

class EntityTest {

    String name
    Long idTenant = 0
    Date dateRegister = new Date()

    static constraints = {

    }

    def beforeInsert(){
        idTenant = EnvironmentHolder?.getEnvironment()?.id
    }
}
