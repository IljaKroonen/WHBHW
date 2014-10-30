package whbhw

class Component {
    String name
    String description
    String type

    static constraints = {
        name nullable:false, blank:false, unique:true
        description nullable:true, blank:false
        type nullable:false
        }
}
