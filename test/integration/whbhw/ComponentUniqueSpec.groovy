package whbhw

import spock.lang.Specification
import spock.lang.Unroll

class ComponentUniqueSpec extends Specification{

    void "test unicité"() {
        given: "Un composant nommé GTX 780"
        def carteGraphiqueComponent = new Component(name:"GTX 780",description:"3072 Mo Dual DVI/HDMI/DisplayPort - PCI Express", type: Type.CARTE_GRAPHIQUE)
        carteGraphiqueComponent.save(flush: true)

        when: "Un nouveau composant nommé GTX 780"
        def carteGraphiqueComponent2 = new Component(name:"GTX 780",description:"2048 Mo Dual DVI/HDMI/DisplayPort - PCI Express", type: Type.CARTE_GRAPHIQUE)

        then: "Alors on ne peut pas créer l'objet"
        !carteGraphiqueComponent2.validate()
    }

}
