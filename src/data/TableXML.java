package data;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
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

    }

    @Override
    public List<IField> getFields() {
        return null;
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
            String path = DatabaseManager.getInstance().databasePath(databaseName) + "/" + name + ".xsc";
            StreamResult result = new StreamResult(new File(path));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean fieldExists(IField field) {
        return false;
    }
}
