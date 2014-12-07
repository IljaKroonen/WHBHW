package whbhw

class Component {
    String name
    String description
    Type type

    static constraints = {
        name nullable:false, blank:false, unique:true
        description nullable:true, blank:false, size: 0..4000
        type nullable:false
        }
}
