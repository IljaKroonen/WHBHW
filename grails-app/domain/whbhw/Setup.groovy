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
        return "Setup{" +
                "id=" + id +
                ", user=" + user +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", version=" + version +
                ", components=" + components +
                ", evaluations=" + evaluations +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Setup setup = (Setup) o

        if (components != setup.components) return false
        if (description != setup.description) return false
        if (evaluations != setup.evaluations) return false
        if (id != setup.id) return false
        if (name != setup.name) return false
        if (user != setup.user) return false
        if (version != setup.version) return false

        return true
    }

    int hashCode() {
        int result
        result = (user != null ? user.hashCode() : 0)
        result = 31 * result + (name != null ? name.hashCode() : 0)
        result = 31 * result + (description != null ? description.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (version != null ? version.hashCode() : 0)
        result = 31 * result + (components != null ? components.hashCode() : 0)
        result = 31 * result + (evaluations != null ? evaluations.hashCode() : 0)
        return result
    }
}
