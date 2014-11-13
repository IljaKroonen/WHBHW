import grails.plugin.springsecurity.SpringSecurityService

class LogoutController {

    /**
     * Index action. Redirects to the Spring security logout uri.
     */
    def index = {
        // TODO put any pre-logout code here
        redirect uri: SpringSecurityServiceecurityUtils.securityConfig.logout.filterProcessesUrl // '/j_spring_security_logout'
    }
}
