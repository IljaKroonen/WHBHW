package whbhw


import grails.transaction.Transactional

@Transactional(readOnly = true)
class EvaluationController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Evaluation.list(params), model: [evaluationInstanceCount: Evaluation.count()]
    }

    def show(Evaluation evaluationInstance) {
        respond evaluationInstance
    }

    def create() {
        respond new Evaluation(params)
    }

    @Transactional
    def save(Evaluation evaluationInstance) {
        if (evaluationInstance == null) {
            notFound()
            return
        }

        if (evaluationInstance.hasErrors()) {
            respond evaluationInstance.errors, view: 'create'
            return
        }

        evaluationInstance.save flush: true

        redirect(controller: "Setup", action: "index", id: evaluationInstance.setup.id)

    }

    def edit(Evaluation evaluationInstance) {
        respond evaluationInstance
    }

    @Transactional
    def update(Evaluation evaluationInstance) {
        if (evaluationInstance == null) {
            notFound()
            return
        }

        if (evaluationInstance.hasErrors()) {
            respond evaluationInstance.errors, view: 'edit'
            return
        }

        evaluationInstance.save flush: true

        redirect(controller: "Setup", action: "index", id: evaluationInstance.setup.id)
    }

    @Transactional
    def delete(Evaluation evaluationInstance) {

        if (evaluationInstance == null) {
            notFound()
            return
        }

        evaluationInstance.delete flush: true

        redirect(controller: "Setup", action: "index", id: evaluationInstance.setup.id)
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'evaluation.label', default: 'Evaluation'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
