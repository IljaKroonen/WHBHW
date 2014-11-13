package whbhw


import grails.transaction.Transactional
import org.codehaus.groovy.grails.plugins.springsecurity.SpringSecurityUtils
import org.springframework.security.access.annotation.Secured

@Transactional(readOnly = true)
class SetupController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    @Secured(['ROLE_ADMIN'])
    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Setup.list(params), model: [setupInstanceCount: Setup.count()]
    }

    def show(Setup setupInstance) {
        respond setupInstance
    }

    def create() {
        respond new Setup(params)
    }

    @Transactional
    def save(Setup setupInstance) {
        if (setupInstance == null) {
            notFound()
            return
        }

        if (setupInstance.hasErrors()) {
            respond setupInstance.errors, view: 'create'
            return
        }

        setupInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'setup.label', default: 'Setup'), setupInstance.id])
                redirect setupInstance
            }
            '*' { respond setupInstance, [status: CREATED] }
        }
    }

    def edit(Setup setupInstance) {
        respond setupInstance
    }

    @Transactional
    def update(Setup setupInstance) {
        if (setupInstance == null) {
            notFound()
            return
        }

        if (setupInstance.hasErrors()) {
            respond setupInstance.errors, view: 'edit'
            return
        }

        setupInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Setup.label', default: 'Setup'), setupInstance.id])
                redirect setupInstance
            }
            '*' { respond setupInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Setup setupInstance) {

        if (setupInstance == null) {
            notFound()
            return
        }

        setupInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Setup.label', default: 'Setup'), setupInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'setup.label', default: 'Setup'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
