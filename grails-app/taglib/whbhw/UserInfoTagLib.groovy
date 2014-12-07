package whbhw

class UserInfoTagLib {
    static defaultEncodeAs = [taglib:'html']

    def userInfo = { attrs, body ->
        def configurations = "${Setup.findAllByUser(User.findByUsername(attrs.username)).count {ite -> ite} }"
        def evaluations = "${Evaluation.findAllByUser(User.findByUsername(attrs.username)).count {ite -> ite} }"
        out << "${attrs.username} - ${configurations} "
        if (configurations > 1)
            out << "configurations"
        else
            out << "configuration"
        out << " - ${evaluations} "
        if (evaluations > 1)
            out << "évaluations"
        else
            out << "évaluation"
    }
}
