package se.alex.lexicon.dao.impl.sequencer;

public class TodoItemIdSequencer {
    private static int currentId = 0;

    private TodoItemIdSequencer() {
    }

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemIdSequencer.currentId = currentId;
    }
}
