package org.test;


import difflib.Chunk;
import difflib.Delta;
import difflib.PatchFailedException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Test {

    public static void main(String[] args) throws IOException, PatchFailedException {

        Test test = new Test();

        String dirPath1 = "test1.xml";
        File file1 = new File(dirPath1);
        String dirPath2 = "test2.xml";
        File file2 = new File(dirPath2);

        FileComparator fileComparator = new FileComparator(file1, file2);
        List<Chunk> chunks = fileComparator.getChunksByType(Delta.TYPE.CHANGE);

        for (int i = 0; i < chunks.size(); i++) {
            System.out.println("Diff number " + (i+1));
            Chunk chunk = chunks.get(i);
            int line = chunk.getPosition() + 1;
            System.out.println("Diff is on line " + line);
            List<String> changes = chunk.getLines();
            System.out.println("The diff is:");
            for (int j = 0; j <changes.size() ; j++) {
                System.out.println(changes.get(j));
            }
            //System.out.println("Diff new value- " +changes2);
        }

    }




}
