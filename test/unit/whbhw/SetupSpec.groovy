package whbhw

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Setup)
class SetupSpec extends Specification {

    void "Correct setup"() {
        given: "Correct values for a setup"
        def Setup setup = new Setup()
        setup.name = aName
        setup.description = aDescription
        setup.components = aComponentList
        setup.user = aUser

        when: "attempting to validate"
        def r = setup.validate()

        then: "the user is validated"
        r

        where:
        aName             | aDescription       | aComponentList    | aUser
        "Ma super config" | "Super config abc" | null              | Mock(User)
        "Ma super config" | ""                 | [Mock(Component)] | Mock(User)
        "Ma super config" | ""                 | []                | Mock(User)

    }

    void "Incorrect setup"() {
        given: "Incorrect values for a setup"
        def Setup setup = new Setup()
        setup.name = aName
        setup.description = aDescription
        setup.components = aComponentList
        setup.user = aUser

        when: "attempting to validate"
        def r = setup.validate()

        then: "the user is not validated"
        !r

        where:
        aName      | aDescription             | aComponentList    | aUser
        null       | "Super config trop bien" | [Mock(Component)] | Mock(User)
        "Goobypls" | null                     | [Mock(Component)] | Mock(User)
        "g"        | "Super config trop bien" | [Mock(Component)] | Mock(User)
        ""         | "Super config trop bien" | [Mock(Component)] | Mock(User)
    }
}
