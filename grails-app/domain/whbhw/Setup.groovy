package whbhw

class Setup {
    User user
    String name
    String description

    static hasMany = [components: Component]

    static constraints = {
    }
}
