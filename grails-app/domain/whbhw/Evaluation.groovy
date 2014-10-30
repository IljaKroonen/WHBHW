package whbhw

class Evaluation {
    User user
    Setup setup
    int grade
    String comment

    static constraints = {
        user nullable: false
        grade nullable: false, range: 1..5
        comment nullable: true
        setup nullable: false
    }
}