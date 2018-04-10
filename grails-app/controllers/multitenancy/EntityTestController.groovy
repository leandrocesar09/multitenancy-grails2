package multitenancy



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class EntityTestController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EntityTest.list(params), model:[entityTestInstanceCount: EntityTest.count()]
    }

    def show(EntityTest entityTestInstance) {
        respond entityTestInstance
    }

    def create() {
        respond new EntityTest(params)
    }

    @Transactional
    def save(EntityTest entityTestInstance) {
        if (entityTestInstance == null) {
            notFound()
            return
        }

        if (entityTestInstance.hasErrors()) {
            respond entityTestInstance.errors, view:'create'
            return
        }

        entityTestInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'entityTest.label', default: 'EntityTest'), entityTestInstance.id])
                redirect entityTestInstance
            }
            '*' { respond entityTestInstance, [status: CREATED] }
        }
    }

    def edit(EntityTest entityTestInstance) {
        respond entityTestInstance
    }

    @Transactional
    def update(EntityTest entityTestInstance) {
        if (entityTestInstance == null) {
            notFound()
            return
        }

        if (entityTestInstance.hasErrors()) {
            respond entityTestInstance.errors, view:'edit'
            return
        }

        entityTestInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EntityTest.label', default: 'EntityTest'), entityTestInstance.id])
                redirect entityTestInstance
            }
            '*'{ respond entityTestInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(EntityTest entityTestInstance) {

        if (entityTestInstance == null) {
            notFound()
            return
        }

        entityTestInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EntityTest.label', default: 'EntityTest'), entityTestInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'entityTest.label', default: 'EntityTest'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
