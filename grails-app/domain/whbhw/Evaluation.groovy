package whbhw

class Evaluation {
    User user
    Setup setup
    int grade
    String comment

    static mapping = {
        user lazy: false
        setup lazy: false
    }

    static constraints = {
        user nullable: false
        grade nullable: false, range: 1..5
        comment nullable: true
        setup nullable: false
    }

    @Override
    public String toString() {
        return "Evaluation{" +
                "id=" + id +
                ", user=" + user +
                ", setup=" + setup +
                ", grade=" + grade +
                ", comment='" + comment + '\'' +
                ", version=" + version +
                '}';
    }
}