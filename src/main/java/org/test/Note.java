package org.test;

public class Note {
    private NoteNotation noteNotation;
    private NotePitch notePitch;

    public NoteNotation getNoteNotation() {
        return noteNotation;
    }

    public void setNoteNotation(NoteNotation noteNotation) {
        this.noteNotation = noteNotation;
    }

    public NotePitch getNotePitch() {
        return notePitch;
    }

    public void setNotePitch(NotePitch notePitch) {
        this.notePitch = notePitch;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteNotation=" + noteNotation +
                ", notePitch=" + notePitch +
                '}';
    }
}
