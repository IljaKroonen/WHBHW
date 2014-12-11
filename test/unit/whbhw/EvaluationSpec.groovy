package whbhw

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * Created by Ilja on 30/10/2014.
 */
@TestFor(Evaluation)
class EvaluationSpec extends Specification {
    void "Correct evaluation"() {
        given: "Correct values for an evaluation"
        def Evaluation eval = new Evaluation()
        eval.user = aUser
        eval.grade = aGrade
        eval.setup = aSetup
        eval.comment = aComment

        when: "attempting to validate"
        def r = eval.validate()

        then: "the evaluation is validated"
        r

        where:
        aUser      | aGrade | aSetup      | aComment
        Mock(User) | 1      | Mock(Setup) | null
        Mock(User) | 5      | Mock(Setup) | "Super config beau boulot"
    }

    void "Incorrect evaluation"() {
        given: "Incorrect values for an evaluation"
        def Evaluation eval = new Evaluation()
        eval.user = aUser
        eval.grade = aGrade
        eval.setup = aSetup
        eval.comment = aComment

        when: "attempting to validate"
        def r = eval.validate()

        then: "the evaluation is not validated"
        !r

        where:
        aUser      | aGrade | aSetup      | aComment
        Mock(User) | 0      | Mock(Setup) | null
        Mock(User) | 5      | null        | "Super config beau boulot"
        null       | 5      | Mock(Setup) | "Super config beau boulot"
    }

    void "test toString()"(){
        given: "Une evaluation"
        Evaluation evaluation = new Evaluation()
        evaluation.user = Mock(User)
        evaluation.setup = Mock(Setup)
        evaluation.grade = 2
        evaluation.comment = "comment"
        evaluation.version = 1

        when: "toString()"
        def string = evaluation.toString()

        then: "retour du string"
        string.equals("Evaluation{" +
                "id=" + evaluation.id +
                ", user=" + evaluation.user +
                ", setup=" + evaluation.setup +
                ", grade=" + evaluation.grade +
                ", comment='" + evaluation.comment + '\'' +
                ", version=" + evaluation.version +
                '}');

    }
}
