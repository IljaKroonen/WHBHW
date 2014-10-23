package whbhw

class Evaluation {
    Setup setup
    int grade
    String comment

    static constraints = {
        grade nullable:false
        comment nullable:true
        setup nullable:true

    }
}