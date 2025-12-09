import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XMLTreeViewer extends JFrame {
    private JTree tree;

    public XMLTreeViewer(String filePath) {
        setTitle("XML Viewer");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("XML");

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File(filePath));
            doc.getDocumentElement().normalize();

            Element root = doc.getDocumentElement();
            DefaultMutableTreeNode rootTreeNode = new DefaultMutableTreeNode(root.getNodeName());
            buildTree(root, rootTreeNode);
            rootNode.add(rootTreeNode);

        } catch (ParserConfigurationException | SAXException | IOException e) {
            JOptionPane.showMessageDialog(this, "Ошибка при чтении XML: " + e.getMessage(),
                    "Ошибка", JOptionPane.ERROR_MESSAGE);
        }

        tree = new JTree(rootNode);
        JScrollPane scrollPane = new JScrollPane(tree);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void buildTree(Node xmlNode, DefaultMutableTreeNode treeNode) {
        NodeList nodeList = xmlNode.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node currentNode = nodeList.item(i);

            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                DefaultMutableTreeNode childTreeNode = new DefaultMutableTreeNode(currentNode.getNodeName());
                buildTree(currentNode, childTreeNode);
                treeNode.add(childTreeNode);
            } else if (currentNode.getNodeType() == Node.TEXT_NODE) {
                String textContent = currentNode.getTextContent().trim();
                if (!textContent.isEmpty()) {
                    treeNode.add(new DefaultMutableTreeNode(textContent));
                }
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            String xmlFilePath = "example.xml";
            XMLTreeViewer viewer = new XMLTreeViewer(xmlFilePath);
            viewer.setVisible(true);
        });
    }
}
