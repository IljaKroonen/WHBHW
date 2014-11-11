import whbhw.Component
import whbhw.Evaluation
import whbhw.Role
import whbhw.Setup
import whbhw.User
import whbhw.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'admin1', enabled: true, password: 'admin1')
        testUser.save(flush: true)

        UserRole.create(testUser, adminRole, true)

        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1


        def testComponent = new Component(name:"Component", description: "desc", type: "carte mere")
        def testComponent1 = new Component(name:"Component1", description: "desc1", type: "carte mere1")
        testComponent.save(flush: true)
        testComponent1.save(flush: true)

        def testSetup = new Setup(user: testUser, name: "setup",description: "desc setup")
        testSetup.addToComponents(testComponent)
        testSetup.addToComponents(testComponent1)

        testSetup.save(flush: true)

        def testEvaluation = new Evaluation(user: testUser, grade: 1, comment: "commentaire", setup: testSetup)
        testEvaluation.save(flush: true)

    }
    def destroy = {
    }
}
