package ru.korus.tmis.pdm.utilities;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.util.xml.SimpleNamespaceContext;
import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        12.04.2013, 11:29:02 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

/**
 *
 */
public class Xml {

    private final static TransformerFactory transformerFactory = TransformerFactory.newInstance();
    private final static XPathFactory xPathFactory = XPathFactory.newInstance();

    static public Document load(String fileName) {
        DocumentBuilderFactory documentBuilderFactory;
        documentBuilderFactory = DocumentBuilderFactory.newInstance();
        try {
            return documentBuilderFactory.newDocumentBuilder().parse(new File(fileName));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static public Document loadString(String data) {
        DocumentBuilderFactory documentBuilderFactory;
        documentBuilderFactory = DocumentBuilderFactory.newInstance();        
        InputSource inputSource = new InputSource(new StringReader(data));
        try {
            return documentBuilderFactory.newDocumentBuilder().parse(inputSource);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public static Document docCopy(Document docTpl) throws TransformerException {
        Transformer transformer = transformerFactory.newTransformer();
        DOMResult result = new DOMResult();
        transformer.transform(new DOMSource(docTpl), result);
        return (Document) result.getNode();
    }

    /**
     * @param doc
     * @return
     * @throws TransformerFactoryConfigurationError
     * @throws TransformerException
     */
    public static String docToString(Document doc) throws TransformerFactoryConfigurationError, TransformerException {
        Transformer transformer = transformerFactory.newTransformer();
        StringWriter stringWriter = new StringWriter();
        transformer.transform(new DOMSource(doc), new StreamResult(stringWriter));
        return stringWriter.toString();

    }

    /**
     *
     * @param doc
     * @param xpath
     * @param value
     * @return
     * @throws XPathExpressionException
     */
    public static Attr setAttrValue(Document doc, String xpath, String value) throws XPathExpressionException {
        Attr res = (Attr)getNode(doc, xpath);
        res.setValue(value);
        return res;
    }

    /**
     * @param doc
     * @param xpath
     * @return
     * @throws XPathExpressionException
     */


    public static Node getNode(Document doc, String xpath) throws XPathExpressionException {
        final XPath xPath = xPathFactory.newXPath();
        return (Node) xPath.compile(xpath).evaluate(doc, XPathConstants.NODE);
    }

    /**
     * @param doc
     * @param xpath
     * @return
     */
    public static String getAttrValue(Document doc, String xpath) {
        String res = null;
        doc.lookupNamespaceURI(null);
        try {
            Attr attr = (Attr)getNode(doc, xpath);
            if (attr != null) {
                res = attr.getValue();
            }
        } catch (XPathExpressionException e) {
            e.printStackTrace();
            res = null;
        }
        return res;
    }

    public static String getElementValue(Document doc, String xpath) {
        String res = null;
        doc.lookupNamespaceURI(null);
        try {
            Element el = (Element)getNode(doc, xpath);
            if (el != null) {
                res = el.getTextContent();
            }
        } catch (XPathExpressionException e) {
            System.out.println("Issue in Xml.getElementValue, xpath = " + xpath);
            e.printStackTrace();
            res = null;
        }
        return res;
    }

    public static void setTextValue(Document doc, String def, String value) throws DOMException, XPathExpressionException {
        Xml.getNode(doc, "//hl7:*[text()='" + def + "']").setTextContent(value);
    }

}
