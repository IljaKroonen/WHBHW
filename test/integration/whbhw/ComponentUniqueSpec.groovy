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

    @Unroll
    void "test equals false"(){
        given: "Deux composants"
        Component component = new Component(name: aName, id: aId, description: aDescription, type: aType , version: aVersion);
        Component component1 = new Component(name: "name", id: 20, description: "description", type: Type.ALIMENTATION, version: 1 );

        when: "equals"
        def sameComp = component.equals(component1)

        then: "test d'égalité"
        if(sameComp==false){
            true
        }else{
            false
        }

        where:
        aName  | aId | aDescription | aType | aVersion
        "name" | 20 | "wrongDescription" | Type.ALIMENTATION | 1
        "wrongName" | 19 | "description" | Type.ALIMENTATION | 1
        "name" | 20 | "description" | Type.BOITIER | 1
        "name" | 20 | "description" | Type.ALIMENTATION | 1
        "name" | 20 | "description" | Type.ALIMENTATION | 2
    }


    void "test equals true"(){
        given: "Un composant"
        Component component = new Component(name: "name", description: "desc", type: Type.ALIMENTATION);

        when: "equals"
        def sameComp = component.equals(component)

        then: "test d'égalité"
        sameComp
    }

    void "test equals avec une autre classe"(){
        given: "Un composant et un user"
        Component component = new Component(name: "name", description: "desc", type: Type.ALIMENTATION);
        User user = new User(username: "user", password: "password")

        when: "equals"
        def sameComp = component.equals(user)

        then: "test d'égalité"
        if(sameComp==false){
            true
        }else{
            false
        }
    }
}
