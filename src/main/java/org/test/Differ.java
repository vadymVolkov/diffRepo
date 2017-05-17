package org.test;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;

public class Differ {
    public static void main(String[] args) {


        NoteNotation noteNotation1 = new NoteNotation("1", "2");
        NoteNotation noteNotation2 = new NoteNotation("2", "3");
        DiffNode diff = ObjectDifferBuilder.buildDefault().compare(noteNotation1, noteNotation2);

        System.out.println(diff.getPropertyAnnotations());
    }
}
