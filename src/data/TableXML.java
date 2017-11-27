package data;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by khaled on 11/25/17.
 */
public class TableXML implements ITable {
    String name;
    String databaseName;

    public TableXML(String databaseName, String name) {
        this.databaseName = databaseName;
        this.name = name;
        initializeTableFiles();
    }

    @Override
    public boolean insert(IRecord record) {
        return false;
    }

    @Override
    public List<IRecord> select(ICondition condition) {
        return null;
    }

    @Override
    public int delete(ICondition condition) {
        return 0;
    }

    @Override
    public int update(ICondition condition, IRecord record) {
        return 0;
    }

    @Override
    public void addField(IField field) {
        if (!fieldExists(field)) {
            List<IField> newFields = getFields();
            newFields.add(field);
            setFields(newFields);
        }
    }

    @Override
    public List<IField> getFields() {
        List<IField> fields = new ArrayList<>();

        try {
            File inputFile = new File(schemaPath());
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            NodeList fieldElements = doc.getElementsByTagName("field");

            for (int i = 0; i < fieldElements.getLength(); i++) {
                Node fieldElement = fieldElements.item(i);

                if (fieldElement.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) fieldElement;
                    String fieldClassName = eElement.getAttribute("class");
                    String fieldName = eElement.getAttribute("name");
                    fields.add(FieldsFactory.create(fieldClassName, fieldName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fields;
    }

    @Override
    public void setFields(List<IField> fields) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element tableElement = doc.createElement("table");
            doc.appendChild(tableElement);

            for (IField field : fields) {
                Element fieldElement = doc.createElement("field");
                tableElement.appendChild(fieldElement);

                Attr nameAttribute = doc.createAttribute("name");
                nameAttribute.setValue(field.getName());
                fieldElement.setAttributeNode(nameAttribute);

                Attr classAttribute = doc.createAttribute("class");
                classAttribute.setValue(field.getClass().getSimpleName());
                fieldElement.setAttributeNode(classAttribute);
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            String path = schemaPath();
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean fieldExists(IField field) {
        for (IField currentField : getFields()) {
            if (field.getName().equals(currentField.getName())) return true;
        }
        return false;
    }

    private void initializeTableFiles() {
        setRecords(new ArrayList<>());
        setFields(new ArrayList<>());
    }

    private List<IRecord> getRecords() {
        List<IRecord> records = new ArrayList<>();
        //TODO read records from XML
        return records;
    }

    private void setRecords(List<IRecord> records) {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element tableElement = doc.createElement("table");
            doc.appendChild(tableElement);

            Attr tableNameAttrubute = doc.createAttribute("name");
            tableNameAttrubute.setValue(this.name);
            tableElement.setAttributeNode(tableNameAttrubute);

            for (IRecord record : records) {
                Element recordElement = doc.createElement("record");
                doc.appendChild(recordElement );


                for (IField field : getFields()) {
                    Object cell = record.getAttribute(field.getName());

                    Element fieldElement = doc.createElement("field");
                    tableElement.appendChild(fieldElement);

                    Attr nameAttribute = doc.createAttribute("name");
                    nameAttribute.setValue(field.getName());
                    fieldElement.setAttributeNode(nameAttribute);

                    Attr classAttribute = doc.createAttribute("class");
                    classAttribute.setValue(field.getClass().getSimpleName());
                    fieldElement.setAttributeNode(classAttribute);

                    tableElement.appendChild(doc.createTextNode(cell.toString()));
                }
            }

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            String path = xmlPath();
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String schemaPath() {
        return DatabaseManager.getInstance().databasePath(databaseName) + "/" + name + ".xsc";
    }

    private String xmlPath() {
        return DatabaseManager.getInstance().databasePath(databaseName) + "/" + name + ".xml";
    }
}
