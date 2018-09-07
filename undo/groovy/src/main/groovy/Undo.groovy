class Undoable {
    Closure d
    Closure u
}

class Undo {
    private Closure u

    void "do"(Undoable undoable) {
        this.u = undoable.u
        undoable.d()
    }

    void "do"(Closure d, Closure u = {}) {
        this.u = u
        d()
    }

    void undo() {
        u()
    }
}
