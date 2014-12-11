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

    @Override
    public String toString() {
        return "Component{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", version=" + version +
                '}';
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        Component component = (Component) o

        if (description != component.description) return false
        if (id != component.id) return false
        if (name != component.name) return false
        if (type != component.type) return false
        if (version != component.version) return false

        return true
    }

    int hashCode() {
        int result
        result = (name != null ? name.hashCode() : 0)
        result = 31 * result + (description != null ? description.hashCode() : 0)
        result = 31 * result + (type != null ? type.hashCode() : 0)
        result = 31 * result + (id != null ? id.hashCode() : 0)
        result = 31 * result + (version != null ? version.hashCode() : 0)
        return result
    }
}
