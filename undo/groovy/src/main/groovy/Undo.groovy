import io.reactivex.Observable

class Undoable {
    Closure action
    Closure reverseAction
}

class Undo {

    private final int maxUndos

    private final List<Undoable> undoStack = []
    private final List<Undoable> redoStack = []

    Undo(maxUndos = 10) {
        this.maxUndos = maxUndos
    }

    void register(Observable<Undoable> undoable) {
        undoable.subscribe({ "do" it })
    }

    // maybe we need `done` iso `do`
    void "do"(Undoable undoable) {
        undoStack << undoable
        if (undoStack.size() > maxUndos) {
            undoStack.remove 0
        }
        redoStack.clear()
        undoable.action()
    }

    void "do"(Closure action, Closure reverseAction = {}) {
        "do"([action: action, reverseAction: reverseAction] as Undoable)
    }

    void undo() {
        if (undoStack.empty) {
            return
        }

        Undoable undoable = undoStack.pop()

        undoable.reverseAction()

        redoStack << undoable
    }

    void redo() {
        if (redoStack.empty) {
            return
        }

        Undoable undoable = redoStack.pop()

        undoable.action()

        undoStack << undoable
    }
}
