package org.test;

import de.danielbechler.diff.ObjectDifferBuilder;
import de.danielbechler.diff.node.DiffNode;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class Compersation {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Parser parser = new Parser();
        DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document document1 = documentBuilder.parse("Sample_cut.xml");
        Document document2 = documentBuilder.parse("Sample_cut2.xml");
        List<Note> notes1 = new ArrayList<>();
        List<Note> notes2 = new ArrayList<>();
        notes1 = parser.parseXml(document1);
        notes2 = parser.parseXml(document2);
        System.out.println(notes1);
        System.out.println(notes2);
        for (int i = 0; i < notes1.size(); i++) {
            Note note1 = notes1.get(i);
            Note note2 = notes2.get(i);
            DiffNode diff = ObjectDifferBuilder.buildDefault().compare(note1, note2);
            System.out.print(diff);
            System.out.println(" Note number " + i);
        }
    }
}
