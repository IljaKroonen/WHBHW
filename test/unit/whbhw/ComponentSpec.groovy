package whbhw

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(Component)
class ComponentSpec extends Specification {

    Component component
    def setup() {
        component = new Component();
    }

    def cleanup() {
    }

    @Unroll
    void "test sur les contraintes d'un composant valide"() {
        given: "un composant"
        component.name = aName
        component.description = aDescription
        component.type = aType

        when: "le composant est valide"
        def valid = component.validate()

        then: "les vérifications de contraintes sont appliquées correctement"
        valid == etatAttendu

        where:
        aName  | aDescription | aType | etatAttendu
        "aop" | "tete" | Mock(Type) | true
        null  | "rer" | Mock(Type) | false
        "aop" | "eee" | Mock(Type) | true
        "opt" | "eeee" | Mock(Type) | true


    }
}
