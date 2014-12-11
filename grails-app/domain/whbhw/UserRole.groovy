package whbhw

import org.apache.commons.lang.builder.HashCodeBuilder

class UserRole implements Serializable {

    User secAppUser
    Role secAppRole

    static UserRole get(long secAppUserId, long secAppRoleId) {
        find 'from UserRole where secAppUser.id=:secAppUserId and secAppRole.id=:secAppRoleId',
                [secAppUserId: secAppUserId, secAppRoleId: secAppRoleId]
    }

    static UserRole create(User secAppUser, Role secAppRole, boolean flush = false) {
        new UserRole(secAppUser: secAppUser, secAppRole: secAppRole).save(flush: flush, insert: true)
    }

    static boolean remove(User secAppUser, Role secAppRole, boolean flush = false) {
        UserRole instance = UserRole.findBySecAppUserAndSecAppRole(secAppUser, secAppRole)
        if (!instance) {
            return false
        }

        instance.delete(flush: flush)
        true
    }

    static void removeAll(User secAppUser) {
        executeUpdate 'DELETE FROM UserRole WHERE secAppUser=:secAppUser', [secAppUser: secAppUser]
    }

    static void removeAll(Role secAppRole) {
        executeUpdate 'DELETE FROM UserRole WHERE secAppRole=:secAppRole', [secAppRole: secAppRole]
    }

    static mapping = {
        id composite: ['secAppRole', 'secAppUser']
        version false
    }


    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", secAppUser=" + secAppUser +
                ", secAppRole=" + secAppRole +
                ", version=" + version +
                '}';
    }
}
