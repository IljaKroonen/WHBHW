package whbhw

class User {

    transient springSecurityService

    String username
    String password
    String email
    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [setup: Setup]

    static constraints = {
        username size: 5..15, blank: false, unique: true
        password blank: false, password: true
        email email:true
        setup nullable:true
    }

    static mapping = {
        password column: '`password`'
    }

    Set<Role> getAuthorities() {
        UserRole.findAllBySecAppUser(this).collect { it.secAppRole } as Set
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService.encodePassword(password)
    }


    @Override
    public String    toString() {
        return "User{" +
                "id=" + id +
                ", springSecurityService=" + springSecurityService +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", accountExpired=" + accountExpired +
                ", accountLocked=" + accountLocked +
                ", passwordExpired=" + passwordExpired +
                ", version=" + version +
                ", setup=" + setup +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        User user = (User) o

        if (accountExpired != user.accountExpired) return false
        if (accountLocked != user.accountLocked) return false
        if (enabled != user.enabled) return false
        if (passwordExpired != user.passwordExpired) return false
        if (java.lang.String != user.String) return false
        if (email != user.email) return false
        if (id != user.id) return false
        if (password != user.password) return false
        if (setup != user.setup) return false
        if (springSecurityService != user.springSecurityService) return false
        if (username != user.username) return false
        if (version != user.version) return false

        return true
    }

    int hashCode() {
        int result
        result = (springSecurityService != null ? springSecurityService.hashCode() : 0)
        result = 31 * result + (username != null ? username.hashCode() : 0)
        result = 31 * result + (password != null ? password.hashCode() : 0)
        result = 31 * result + (email != null ? email.hashCode() : 0)
        result = 31 * result + (enabled ? 1 : 0)
        result = 31 * result + (accountExpired ? 1 : 0)
        result = 31 * result + (accountLocked ? 1 : 0)
        result = 31 * result + (passwordExpired ? 1 : 0)
        result = 31 * result + (java.lang.String != null ? java.lang.String.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (version != null ? version.hashCode() : 0)
        result = 31 * result + (setup != null ? setup.hashCode() : 0)
        return result
    }
}
