package whbhw

class Component {
    String name
    String description

    static hasMany = [setups: Setup]

    static constraints = {

        name nullable:false
        description nullable:true
        setups nullable:true
    }
}
