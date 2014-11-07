package whbhw

class User {

    transient springSecurityService

    String username
    String password
//    String email
    boolean enabled
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static hasMany = [setup: Setup]

    static constraints = {
        username /*size: 5..15,*/ blank: false, unique: true
        password /*size: 5..15,*/ blank: false/*, password: true*/
//        email email:true
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
}
