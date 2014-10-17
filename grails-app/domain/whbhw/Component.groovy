package whbhw

class Component {
    String name
    String description

    static hasMany = [setups: Setup]

    static constraints = {
    }
}
