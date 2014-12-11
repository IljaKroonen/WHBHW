package whbhw

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.support.GrailsUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

    User user

    def setup() {
        user = new User()
    }

    @Unroll
    void "test des contraintes sur un User valide (username : #aUsername)"() {

        given: "Un user valide"
        user.username = aUsername
        user.password = aPassword
        user.email = aEmail

        when: "On declenche la validation du user"
        def res = user.validate()

        then: "Le user n'a pas d'erreurs de validation"
        res == true
        !user.hasErrors()

        where:
        aUsername   | aPassword   | aEmail
        "username1" | "password1" | "email1@test.fr"
        "username2" | "password2" | "email2@test.fr"
        "username3" | "password3" | "email3@test.fr"
    }

    @Unroll
    void "test des contraintes sur un User non valide (username : #aUsername)"() {
        given: "Un user valide"
        user.username = aUsername
        user.password = aPassword
        user.email = aEmail

        when: "On declenche la validation du user"
        def res = user.validate()

        then: "Le user n'a pas d'erreurs de validation"
        res == false
        user.hasErrors()

        where:
        aUsername            | aPassword            | aEmail
        "username1"          | "password1"          | "email1"
        "username2"          | null                 | "email2@test.fr"
        null                 | "password3"          | "email3@test.fr"
        "user"               | "password1"          | "email1@test.fr"
        "username9876543210" | "password1"          | "email1@test.fr"
        /*
        "username3"          | "pass"               | "email3@test.fr"
        "username4"          | "password9876543210" | "email4@test.fr"
        */
    }


    void "test toString()"(){
        given: "Un user"
        User user = new User()
        user.username = "nom"
        user.password = "password"
        user.email = "email@email.com"
        user.version = 1

        when: "toString()"
        def string = user.toString()

        then: "retour du string"
        string.equals("User{" +
                "id=" + user.id +
                ", springSecurityService=" + user.springSecurityService +
                ", username='" + user.username + '\'' +
                ", password='" + user.password + '\'' +
                ", email='" + user.email + '\'' +
                ", enabled=" + user.enabled +
                ", accountExpired=" + user.accountExpired +
                ", accountLocked=" + user.accountLocked +
                ", passwordExpired=" + user.passwordExpired +
                ", version=" + user.version +
                ", setup=" + user.setup +
                '}');
    }
}
