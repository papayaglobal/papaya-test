import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.Subject
import spock.lang.Specification

class UndoTest extends Specification {
    def 'should do'() {
        def done = false

        when:
        new Undo().do({ -> done = true })

        then:
        done
    }

    def 'should undo'() {
        String state = "0"
        def undo = new Undo()

        when:
        undo.do({ -> state = "1" }, { -> state = "0" })
        assert state == "1"
        undo.undo()

        then:
        state == "0"
    }

    def 'should undo v2'() {
        String state = "0"
        def undo = new Undo()

        when:
        undo.do({ -> state = state + "1" }, { -> state = state - "1" })
        assert state == "01"
        undo.undo()

        then:
        state == "0"
    }

    def 'should undo v3'() {
        String state = "0"
        def append = { s -> { -> state = state + s } }
        def undoAppend = { s -> { -> state = state - s } }
        def undo = new Undo()

        when:
        undo.do(append("1"), undoAppend("1"))
        assert state == "01"
        undo.undo()

        then:
        state == "0"
    }

    def 'should undo v4'() {
        String state = "0"
        def append = { s ->
            [
                    action       : { -> state = state + s },
                    reverseAction: { -> state = state - s }
            ] as Undoable
        }
        def undo = new Undo()

        when:
        undo.do(append("1"))
        assert state == "01"
        undo.undo()

        then:
        state == "0"
    }

    def 'should undo v5'() {
        def u = new Undo()
        String state = ""
        def append = { s ->
            u.do([
                    action       : { -> state = state + s },
                    reverseAction: { -> state = state.take(state.length() - s.length()) }
            ] as Undoable)
        }
        def undo = { u.undo() }
        def redo = { u.redo() }

        when:
        "nitzan".each { append it }
        assert state == "nitzan"
        undo()
        assert state == "nitza"
        redo()
        assert state == "nitzan"
        3.times undo
        assert state == "nit"
        append "s"
        assert state == "nits"
        redo()
        assert state == "nits"
        undo()
        assert state == "nit"
        3.times redo
        assert state == "nits"
        append "a"
        append "n"
        assert state == "nitsan"
        10.times undo
        assert state == ""
        10.times redo

        then:
        state == "nitsan"
    }

    def 'should undo v6'() {
        String string = ""
        Subject<Undoable> undoable = PublishSubject.create()
        def u = new Undo(4)
        u.register undoable

        def append = { s ->
            undoable.onNext([
                    action       : { string = string + s },
                    reverseAction: { string = string.take(string.length() - s.length()) }
            ] as Undoable)
        }
        def undo = { u.undo() }
        def redo = { u.redo() }

        when:
        "nitzan".each { append it }
        assert string == "nitzan"
        undo()
        assert string == "nitza"
        redo()
        assert string == "nitzan"
        3.times undo
        assert string == "nit"
        append "s"
        assert string == "nits"
        redo()
        assert string == "nits"
        undo()
        assert string == "nit"
        3.times redo
        assert string == "nits"
        append "a"
        append "n"
        assert string == "nitsan"
        10.times undo
        assert string == "ni"
        10.times redo

        then:
        string == "nitsan"
    }
}
