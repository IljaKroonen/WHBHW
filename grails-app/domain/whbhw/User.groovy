package whbhw

class User {
    String username
    String password
    String email

    static hasMany = [setup: Setup]

    static constraints = {
        username size: 5..15, blank: false, unique: true
        password size: 5..15, blank: false
        setup nullable:true
    }
}
