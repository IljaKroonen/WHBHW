package whbhw

class Setup {
    User user
    String name
    String description

    static hasMany = [components: Component]
    static belongsTo = [Component]

    static constraints = {
        user nullable: false
        name nullable: false, size: 4..150, blank: false
        description nullable: false
        components nullable: true
    }
}
