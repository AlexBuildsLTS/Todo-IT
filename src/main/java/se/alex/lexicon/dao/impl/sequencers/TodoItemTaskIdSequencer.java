package se.alex.lexicon.dao.impl.sequencer;

public class TodoItemTaskIdSequencer {
    private static int currentId = 0;

    private TodoItemTaskIdSequencer() {
    }

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        TodoItemTaskIdSequencer.currentId = currentId;
    }
}
