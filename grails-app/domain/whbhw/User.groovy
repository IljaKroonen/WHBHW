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

}
