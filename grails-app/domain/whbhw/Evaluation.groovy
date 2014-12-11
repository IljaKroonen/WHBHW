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

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Evaluation that = (Evaluation) o

        if (grade != that.grade) return false
        if (comment != that.comment) return false
        if (id != that.id) return false
        if (setup != that.setup) return false
        if (user != that.user) return false
        if (version != that.version) return false

        return true
    }

    int hashCode() {
        int result
        result = (user != null ? user.hashCode() : 0)
        result = 31 * result + (setup != null ? setup.hashCode() : 0)
        result = 31 * result + grade
        result = 31 * result + (comment != null ? comment.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (version != null ? version.hashCode() : 0)
        return result
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