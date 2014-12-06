package whbhw

import grails.transaction.Transactional

import org.springframework.security.access.annotation.Secured
import static org.springframework.http.HttpStatus.*

@Transactional(readOnly = true)
class SetupController {

    def springSecurityService

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Setup.list(params), model: [setupInstanceCount: Setup.count()]
    }

    def show(Setup setupInstance) {
        if (setupInstance == null) {
            notFound()
            return
        }
        [setupInstance: setupInstance, currentLoggedInUser: springSecurityService.currentUser]
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def create() {
        respond new Setup(params)
    }

    @Transactional
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def save(Setup setupInstance) {
        if (setupInstance == null) {
            notFound()
            return
        }

        setupInstance.user = springSecurityService.currentUser

        setupInstance.validate()
        if (setupInstance.hasErrors()) {
            respond setupInstance.errors, view: 'create'
            return
        }

        ArrayList<Component> comp = new ArrayList<Component>()
        comp.add(Component.findByName(params.carteMere))
        comp.add(Component.findByName(params.processeur))
        comp.add(Component.findByName(params.carteGraphique))
        comp.add(Component.findByName(params.ram))
        comp.add(Component.findByName(params.ssd))
        comp.add(Component.findByName(params.disqueDur))
        comp.add(Component.findByName(params.boitier))
        comp.add(Component.findByName(params.alimentation))
        comp.add(Component.findByName(params.ventilateur))

        setupInstance.components = new ArrayList<Component>()
        setupInstance.components.addAll(comp)


        setupInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'setup.label', default: 'Setup'), setupInstance.id])
                redirect setupInstance
            }
            '*' { respond setupInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
    def edit(Setup setupInstance) {
        if (setupInstance == null) {
            respond setupInstance
            return
        }

        if (springSecurityService.currentUser != setupInstance.user) {
            respond 'Only the owner of a setup can modify it'
            return
        }

        respond setupInstance
    }

    @Transactional
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
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
    @Secured(['ROLE_ADMIN', 'ROLE_USER'])
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

    /*
    def addEvaluation(Setup setupInstance, String value){
        SetupService ss = new SetupService()
        Evaluation eval = new Evaluation()
        ss.addEvaluation(setupInstance, eval)
    }
    */
}
