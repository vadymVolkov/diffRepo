package org.test;

public class NoteNotation {
    private String fret;
    private String string;

    public String getFret() {
        return fret;
    }

    public NoteNotation() {
    }

    public NoteNotation(String fret, String string) {
        this.fret = fret;
        this.string = string;
    }

    public void setFret(String fret) {
        this.fret = fret;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public String toString() {
        return "NoteNotation{" +
                "fret='" + fret + '\'' +
                ", string='" + string + '\'' +
                '}';
    }
}
