package whbhw

class Role {

    String authority

    static mapping = {
        cache true
    }

    static constraints = {
        authority blank: false, unique: true
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Role role = (Role) o

        if (authority != role.authority) return false
        if (id != role.id) return false
        if (version != role.version) return false

        return true
    }

    int hashCode() {
        int result
        result = (authority != null ? authority.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (version != null ? version.hashCode() : 0)
        return result
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", authority='" + authority + '\'' +
                ", version=" + version +
                '}';
    }
}
