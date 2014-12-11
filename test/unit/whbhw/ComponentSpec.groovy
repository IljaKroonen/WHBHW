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
        "aop" | "tete" | Type.ALIMENTATION | true
        null  | "rer" | Type.ALIMENTATION | false
        "aop" | "eee" | Type.ALIMENTATION | true
        "opt" | "eeee" | Type.ALIMENTATION | true


    }

    void "test toString()"(){
        given: "Un composant"
        component.name = "nom"
        component.description = "desc"
        component.type = Type.ALIMENTATION
        component.version = 1

        when: "toString()"
        def string = component.toString()

        then: "retour du string"
        string.equals("Component{" +
                "id=" + component.id +
                ", name='" + component.name + '\'' +
                ", description='" + component.description + '\'' +
                ", type=" + component.type +
                ", version=" + component.version +
                '}')
    }

}
