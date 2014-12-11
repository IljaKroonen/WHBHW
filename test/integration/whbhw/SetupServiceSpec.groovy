package whbhw

import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */

class SetupServiceSpec extends Specification {

    def params
    def setup() {
         params = new HashMap()
    }

    void "test search list setup"() {
        given: "params"

        params.query = "compression"
        params.checkBoxSetup = "on"
        params.checkBoxPseudo = "off"
        params.checkBoxComponent = "off"

        when: "searchList"
        def setupList = SetupService.searchList(params)

        then:
        setupList.get(0).name.equals("PC compression")
    }

    void "test search list pseudo"() {
        given: "params"
        params.query = "admin"
        params.checkBoxSetup = "off"
        params.checkBoxPseudo = "on"
        params.checkBoxComponent = "off"

        when: "searchList"
        def setupList = SetupService.searchList(params)

        then:
        setupList.get(0).user.username.equals("admin1")
    }

    void "test search list component"() {
        given: "params"
        params.query = "Asus"
        params.checkBoxSetup = "off"
        params.checkBoxPseudo = "off"
        params.checkBoxComponent = "on"

        when: "searchList"
        def setupList = SetupService.searchList(params)

        then:
        setupList.get(0).name.equals("PC compression")
    }

    void "test params.query == null"() {
        given: "params"
        params.query = null
        params.checkBoxSetup = "off"
        params.checkBoxPseudo = "off"
        params.checkBoxComponent = "off"

        when: "searchList"
        def setupList = SetupService.searchList(params)

        then:
        setupList.size() == 1
    }

    void "test off every where"() {
        given: "params"
        params.query = "value"
        params.checkBoxSetup = "off"
        params.checkBoxPseudo = "off"
        params.checkBoxComponent = "off"

        when: "searchList"
        def setupList = SetupService.searchList(params)

        then:
        setupList.size() == 1
    }


}
