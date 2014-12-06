import whbhw.Component
import whbhw.Evaluation
import whbhw.Role
import whbhw.Setup
import whbhw.Type
import whbhw.User
import whbhw.UserRole

class BootStrap {

    def init = { servletContext ->
        def adminRole = new Role(authority: 'ROLE_ADMIN').save(flush: true)
        def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

        def testUser = new User(username: 'admin1', enabled: true, email: "admin1@example.org")
        testUser.setPassword("admin1")
        assert testUser.validate()
        testUser.save(flush: true)

        UserRole.create(testUser, adminRole, true)

        assert User.count() == 1
        assert Role.count() == 2
        assert UserRole.count() == 1

        /*Rajout*/
        def carteMereComponent = new Component(name:"carteMere",description:"descriptionCarteMere", type: Type.CARTE_MERE)
        def carteMereComponent2 = new Component(name:"carteMere2",description:"descriptionCarteMere2", type: Type.CARTE_MERE)

        def processeurComponent = new Component(name:"processeur",description:"descriptionProcesseur", type: Type.PROCESSEUR)
        def processeurComponent2 = new Component(name:"processeur2",description:"descriptionProcesseur2", type: Type.PROCESSEUR)

        def carteGraphiqueComponent = new Component(name:"carteGraphique",description:"descriptionCarteGraphique", type: Type.CARTE_GRAPHIQUE)
        def carteGraphiqueComponent2 = new Component(name:"carteGraphique2",description:"descriptionCarteGraphique2", type: Type.CARTE_GRAPHIQUE)

        def ventilateurComponent = new Component(name:"ventilateur",description:"descriptionVentilateur", type: Type.VENTILATEUR)
        def ventilateurComponent2 = new Component(name:"ventilateur2",description:"descriptionVentilateur2", type: Type.VENTILATEUR)

        def disqueDurComponent = new Component(name:"disqueDur",description:"descriptionDisqueDur", type: Type.DISQUE_DUR)
        def disqueDurComponent2 = new Component(name:"disqueDur2",description:"descriptionDisqueDur2", type: Type.DISQUE_DUR)

        def ssdComponent = new Component(name:"ssd",description:"descriptionSsd", type: Type.SSD)
        def ssdComponent2 = new Component(name:"ssd2",description:"descriptionSsd2", type: Type.SSD)

        def boitierComponent = new Component(name:"boitier",description:"descriptionBoitier", type: Type.BOITIER)
        def boitierComponent2 = new Component(name:"boitier2",description:"descriptionBoitier2", type: Type.BOITIER)

        def alimentationComponent = new Component(name:"alimentation",description:"descriptionAlimentation", type: Type.ALIMENTATION)
        def alimentationComponent2 = new Component(name:"alimentation2",description:"descriptionAlimentation2", type: Type.ALIMENTATION)

        def ramComponent = new Component(name:"ram",description:"descriptionRam", type: Type.RAM)
        def ramComponent2 = new Component(name:"ram2",description:"descriptionRam2", type: Type.RAM)

        carteMereComponent.save(flush: true)
        carteMereComponent2.save(flush: true)
        carteGraphiqueComponent.save(flush: true)
        carteGraphiqueComponent2.save(flush: true)
        processeurComponent.save(flush: true)
        processeurComponent2.save(flush: true)
        ventilateurComponent.save(flush: true)
        ventilateurComponent2.save(flush: true)
        disqueDurComponent.save(flush: true)
        disqueDurComponent2.save(flush: true)
        ssdComponent.save(flush: true)
        ssdComponent2.save(flush: true)
        boitierComponent.save(flush: true)
        boitierComponent2.save(flush: true)
        alimentationComponent.save(flush: true)
        alimentationComponent2.save(flush: true)
        ramComponent.save(flush: true)
        ramComponent2.save(flush: true)



        def testComponent = new Component(name:"Component", description: "desc", type: "carte mere")
        def testComponent1 = new Component(name:"Component1", description: "desc1", type: "carte mere1")
        testComponent.save(flush: true)
        testComponent1.save(flush: true)

        def testSetup = new Setup(user: testUser, name: "setup",description: "desc setup")
        testSetup.addToComponents(testComponent)
        testSetup.addToComponents(testComponent1)

        //testSetup.save(flush: true)

        //def testEvaluation = new Evaluation(user: testUser, grade: 1, comment: "commentaire", setup: testSetup)
        //testEvaluation.save(flush: true)

    }
    def destroy = {
    }
}
