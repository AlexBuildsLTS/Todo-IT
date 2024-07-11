package se.alex.lexicon.dao.impl.sequencer;

public class PersonIdSequencer {
    private static int currentId = 0;

    private PersonIdSequencer() {
    }

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        PersonIdSequencer.currentId = currentId;
    }
}
