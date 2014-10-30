package whbhw

import grails.transaction.Transactional

@Transactional
class ComponentService {

    /**
     * Crée un composant
     * @param name, description, type
     * @return le composant créé
     */

    Component createNewComponent(String name,String description,String type) {
        Component component = new Component(name: name,description: description,type: type)
        component.save()
        component
    }

    def getByName(String name) {
        def result = new ArrayList<Component>()
        result = Component.findAllByNameLike(name)
        return result

    }

    def getByType(String type) {
        def result = new ArrayList<Component>()
        result = Component.findAllByType(type)
        return result

    }
}
