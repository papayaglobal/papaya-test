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
                    d: { -> state = state + s },
                    u: { -> state = state - s }
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
        def undo = new Undo()
        String state = ""
        def append = { s ->
            undo.do([
                    d: { -> state = state + s },
                    u: { -> state = state.take(state.length() - s.length()) }
            ] as Undoable)
        }

        when:
        append("n")
        append("i")
        append("t")
        append("z")
        append("an")
        assert state == "nitzan"
        undo.undo()

        then:
        state == "nitz"
    }
}
