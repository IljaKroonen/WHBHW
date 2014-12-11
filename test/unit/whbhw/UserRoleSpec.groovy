package whbhw

import grails.test.mixin.Mock
import grails.test.mixin.TestMixin
import grails.test.mixin.support.GrailsUnitTestMixin
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestMixin(GrailsUnitTestMixin)
class UserRoleSpec extends Specification {


    void "create"() {
        given: "create from scratch"
        User u = Mock(User)
        Role r = Mock(Role)

        when: "creation"
        UserRole ur = UserRole.create(u,r)

        then: "the user is validated"
        ur
    }

    /*void "get"() {
        given: "get a UserRole"
        User u = Mock(User)
        Role r = Mock(Role)
        UserRole ur = Mock(UserRole).create(u,r, true)

        when: "get it"
        UserRole ur2 = Mock(UserRole).get(u.getId(), r.getId())

        then: "equals"
        ur.equals(ur2)
    }

    void "remove success"() {
        given: "remove a UserRole"
        User u = Mock(User)
        Role r = Mock(Role)
        UserRole ur = UserRole.create(u,r, true)

        when: "removing"
        boolean b = ur.remove(u,r, true)

        then: "ok"
        b
    }*/

    void "remove fail"() {
        given: "remove a UserRole"
        User u = Mock(User)
        User u2 = Mock(User)
        Role r = Mock(Role)
        UserRole ur = UserRole.create(u,r, true)

        when: "removing"
        boolean b = ur.remove(u2,r, true)

        then: "ko"
        !b
    }

}
