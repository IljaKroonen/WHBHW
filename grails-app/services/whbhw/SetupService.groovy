package whbhw

import grails.transaction.Transactional

@Transactional
class SetupService {

    public static List<Setup> searchList(Map params){
        def setupList = Setup.createCriteria().list(params) {
            if (params.query && params.checkBoxSetup == "on") {
                ilike("name", "%${params.query}%")
            }
            if (params.query && params.checkBoxPseudo == "on") {
                user{
                    ilike("username", "%${params.query}%")
                }
            }
            if (params.query && params.checkBoxComponent == "on") {
                components {
                    ilike("name", "%${params.query}%")
                }
            }
        }
        setupList
    }
}
