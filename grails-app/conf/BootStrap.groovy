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
        def carteMereComponent = new Component(name:"Asrock Z87-Pro4",description:"Carte mère socket 1050 compatible Haswell", type: Type.CARTE_MERE)
        def carteMereComponent2 = new Component(name:"Asus Z87-A",description:"Carte mère socket 1050 compatible Haswell", type: Type.CARTE_MERE)

        def processeurComponent = new Component(name:"i5 2500K",description:"Socket 1150, 95W, 32nm, 3.3 Ghz", type: Type.PROCESSEUR)
        def processeurComponent2 = new Component(name:"i7 4790K",description:"Socket 1150, 88W, 22nm, 4 Ghz", type: Type.PROCESSEUR)

        def carteGraphiqueComponent = new Component(name:"GTX 780",description:"3072 Mo Dual DVI/HDMI/DisplayPort - PCI Express", type: Type.CARTE_GRAPHIQUE)
        def carteGraphiqueComponent2 = new Component(name:"GTX 660",description:"2048 Mo Dual DVI/HDMI/DisplayPort - PCI Express", type: Type.CARTE_GRAPHIQUE)

        def ventilateurComponent = new Component(name:"Be Quiet DARK ROCK PRO 3",description:"7 caloducs - 2 ventilateurs SilentWings - 26.1 dB (A) max - compatible avec l'ensemble les plateformes Intel et AMD actuelles", type: Type.VENTILATEUR)
        def ventilateurComponent2 = new Component(name:"COOLER MASTER Hyper 212 Evo",description:"Cuivre et aluminium - 4 caloducs à contact direct - 9-31 dBA - Socket INTEL LGA 1366 / 1156 / 1155 / 775 et AMD FM1 / AM3+ / AM3 / AM2+ / AM2", type: Type.VENTILATEUR)

        def disqueDurComponent = new Component(name:"WESTERN DIGITAL Caviar Green - 1 To",description:"SATA 6Go/s - 64 Mo Cache WD10EZRX - version OEM (sans boîte/ni manuel)", type: Type.DISQUE_DUR)
        def disqueDurComponent2 = new Component(name:"WESTERN DIGITAL Caviar Red - 1 To",description:"SATA III 6Gb/s - 64 Mo cache - disque dur spécial pour NAS - version OEM (sans boîte/ni manuel)", type: Type.DISQUE_DUR)

        def ssdComponent = new Component(name:"SAMSUNG SSD Serie 840 EVO - 2.5 pouces - 250 Go - SATA III",description:"Controleur Samsung 3-Core MCX - Support du TRIM/SMART", type: Type.SSD)
        def ssdComponent2 = new Component(name:"SSD KINGSTON SSD V300 - 120 Go - SATA III",description:"2.5 pouces - MLC - contrôleur LSI SandForce", type: Type.SSD)

        def boitierComponent = new Component(name:"COOLER MASTER Silencio 550 Noir",description:"Moyen tour - ATX / Micro-ATX - Sans alimentation - Noir", type: Type.BOITIER)
        def boitierComponent2 = new Component(name:"COOLER MASTER HAF-X",description:"Grand tour - XL-ATX / E-ATX / ATX / Micro ATX - Sans alimentation - USB 3.0 - 4 ventilateurs inclus - Noir", type: Type.BOITIER)

        def alimentationComponent = new Component(name:"CORSAIR CX Bronze - 600 W",description:"Certification 80 Plus Bronze - 600W - Garantie 3 ans", type: Type.ALIMENTATION)
        def alimentationComponent2 = new Component(name:"COOLER MASTER GM 750 Modulaire",description:"750W - Certification 80Plus Bronze - 4 Ports PCI-E - 8 ports SATA", type: Type.ALIMENTATION)

        def ramComponent = new Component(name:"G.Skill Ripjaws X Series - 8Go ( 2x 4 Go ) PC12800 1600 Mhz CL9",description:"F3-12800CL9D-8GBXL Dual Channel - CL 9-9-9-24 - Compatible Sandybridge - 1.50V", type: Type.RAM)
        def ramComponent2 = new Component(name:"Crucial Ballistix Sport 4Go PC12800 1600Mhz CL9 1.35V",description:"BLS4G3N169ES4CEU - SODIMM 204pin", type: Type.RAM)

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

        def testSetup = new Setup(user: testUser, name: "PC compression",description: "Ordinateur orienté compression vidéo")
        testSetup.addToComponents(carteMereComponent2)
        testSetup.addToComponents(carteGraphiqueComponent2)
        testSetup.addToComponents(processeurComponent)
        testSetup.addToComponents(ventilateurComponent2)
        testSetup.addToComponents(disqueDurComponent)
        testSetup.addToComponents(boitierComponent)
        testSetup.addToComponents(alimentationComponent)
        testSetup.addToComponents(ramComponent2)

        testSetup.save(flush: true)

        def testSetup2 = new Setup(user: testUser, name: "PC test",description: "Ordinateur orienté test")
        testSetup2.addToComponents(carteMereComponent)
        testSetup2.addToComponents(carteGraphiqueComponent)
        testSetup2.addToComponents(processeurComponent)
        testSetup2.addToComponents(ventilateurComponent)
        testSetup2.addToComponents(disqueDurComponent)
        testSetup2.addToComponents(boitierComponent)
        testSetup2.addToComponents(alimentationComponent)
        testSetup2.addToComponents(ramComponent)

        testSetup.save(flush: true)
    }
    def destroy = {
    }
}
