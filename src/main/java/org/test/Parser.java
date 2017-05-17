package org.test;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

public class Parser {
    public  List<Note> parseXml(Document document) {
        List<Note> notes = new ArrayList<>();
        try {
            List<NotePitch> notePitches = makeNotesPitches(document);
            List<NoteNotation> noteNotations = makeNotesNotations(document);
            for (int i = 0; i < notePitches.size(); i++) {
                Note note = new Note();
                note.setNoteNotation(noteNotations.get(i));
                note.setNotePitch(notePitches.get(i));
                notes.add(note);
            }

        } catch (XPathExpressionException e) {
            e.printStackTrace();
        }
        return notes;

    }

    private static List<NoteNotation> makeNotesNotations(Document document) throws XPathExpressionException {
        System.out.println("Get data from Notation tag");
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        List<NoteNotation> noteNotations = new ArrayList<>();
        XPathExpression expr = xpath.compile("//notations/technical");
        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            NodeList technical = n.getChildNodes();
            int length = technical.getLength();
            String exValue1 = "";
            String exValue2 = "";
            NoteNotation noteNotation = new NoteNotation();
            for (int j = 1; j < length; j++) {
                String nodeName = technical.item(j).getNodeName();
                if (nodeName.equals("fret")) {
                    exValue1 = technical.item(j).getTextContent();
                    noteNotation.setFret(exValue1);
                }
                if (nodeName.equals("string")) {
                    exValue2 = technical.item(j).getTextContent();
                    noteNotation.setString(exValue2);
                }
            }
            noteNotations.add(noteNotation);
        }
        return noteNotations;
    }

    private static List<NotePitch> makeNotesPitches(Document document) throws DOMException, XPathExpressionException {
        System.out.println("Get data from Pitch tag");
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        List<NotePitch> notePitches = new ArrayList<>();

        // Пример записи XPath
        // Подный путь до элемента
        //XPathExpression expr = xpath.compile("BookCatalogue/Book/Cost");
        // Все элементы с таким именем
        //XPathExpression expr = xpath.compile("//Cost");
        // Элементы, вложенные в другой элемент
        XPathExpression expr = xpath.compile("//pitch");
        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            NodeList pich = n.getChildNodes();
            int length = pich.getLength();
            NotePitch notePitch = new NotePitch();
            String exValue1 = "";
            String exValue2 = "";
            String exValue3 = "";
            for (int j = 1; j < length; j++) {
                String nodeName = pich.item(j).getNodeName();
                if (nodeName.equals("step")) {
                    exValue1 = pich.item(j).getTextContent();
                    notePitch.setStep(exValue1);
                }
                if (nodeName.equals("alter")) {
                    exValue2 = pich.item(j).getTextContent();
                    notePitch.setAlter(exValue2);
                }
                if (nodeName.equals("octave")) {
                    exValue3 = pich.item(j).getTextContent();
                    notePitch.setOctave(exValue3);
                }
            }
            notePitches.add(notePitch);
        }
        return notePitches;
    }
}
