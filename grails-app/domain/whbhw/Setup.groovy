package whbhw

class Setup {
    User user
    String name
    String description

    static hasMany = [components: Component,evaluations: Evaluation]

    static constraints = {
        user nullable: false
        name nullable: false, size: 4..150, blank: false
        description nullable: false
        components nullable: true
        evaluations nullable: true
    }


    @Override
    public String toString() {
        return name;
    }

}
