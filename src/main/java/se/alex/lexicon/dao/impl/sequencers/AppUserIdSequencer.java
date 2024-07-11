package se.alex.lexicon.dao.impl.sequencer;

public class AppUserIdSequencer {
    private static int currentId = 0;

    private AppUserIdSequencer() {
    }

    public static int nextId() {
        return ++currentId;
    }

    public static int getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(int currentId) {
        AppUserIdSequencer.currentId = currentId;
    }
}
