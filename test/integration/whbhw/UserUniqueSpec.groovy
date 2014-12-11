package whbhw


import spock.lang.Specification

/**
 *
 */
class UserUniqueSpec extends Specification {


    void "test unicité"() {
        given: "Un user nommé Pseudo"
        def user = new User(username:"Pseudo",password: "password", email: "email@email.com")
        user.save(flush: true)

        when: "Un nouveau user nommé Pseudo"
        def user2 = new User(username:"Pseudo",password: "password1", email: "email1@email.com")

        then: "Alors on ne peut pas créer l'objet"
        !user2.validate()
    }
}
