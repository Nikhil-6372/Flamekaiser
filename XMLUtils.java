package com.example.taskmanagement;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class XMLUtils {
    private static final String FILE_PATH = "tasks.xml";

    public static List<Task> readTasks() {
        List<Task> tasks = new ArrayList<>();
        try {
            File xmlFile = new File(FILE_PATH);
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            NodeList nodeList = doc.getElementsByTagName("task");

            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String title = element.getElementsByTagName("title").item(0).getTextContent();
                    boolean completed = Boolean.parseBoolean(element.getElementsByTagName("completed").item(0).getTextContent());
                    tasks.add(new Task(title, completed));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tasks;
    }

    public static void addTask(Task task) {
        // Implement method to add task to XML
    }
}
