package whbhw

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.validation.ValidationException
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ComponentService)
@Mock(Component)
class ComponentServiceSpec extends Specification {

    ComponentService componentService
    def setup() {
        componentService = new ComponentService()
        // Workaround for GRAILS-10538
        componentService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
    }

    void "la creation d'un composant"() {
        given:"creation composant"

        when:"un composant est créer"
        def component = componentService.createNewComponent("i5","processeur style","processeur")

        then:"le composant est trouvé"
        component.getName() == "i5"
        component.getDescription() == "processeur style"
        component.getType() == "processeur"
    }
}
