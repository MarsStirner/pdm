package ru.korus.tmis.pdm.utilities;

import java.io.File;
import java.io.IOException;
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
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
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
        documentBuilderFactory.setNamespaceAware(false);
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
        Attr res = getAttr(doc, xpath);
        res.setValue(value);
        return res;
    }

    /**
     * @param doc
     * @param xpath
     * @return
     * @throws XPathExpressionException
     */
    public static Attr getAttr(Document doc, String xpath) throws XPathExpressionException {
        return (Attr) xPathFactory.newXPath().evaluate(xpath, new DOMSource(doc), XPathConstants.NODE);
    }

    public static Element getElement(Document doc, String xpath) throws XPathExpressionException {
        return (Element) xPathFactory.newXPath().evaluate(xpath, new DOMSource(doc), XPathConstants.NODE);
    }

    /**
     * @param doc
     * @param xpath
     * @return
     */
    public static String getAttrValue(Document doc, String xpath) {
        String res = null;
        try {
            Attr attr = getAttr(doc, xpath);
            if (attr != null) {
                res = attr.getValue();
            }
        } catch (XPathExpressionException e) {
            res = null;
        }
        return res;
    }

    public static void setTextValue(Document doc, String def, String value) throws DOMException, XPathExpressionException {
        Xml.getElement(doc, "//hl7:*[text()='" + def + "']").setTextContent(value);
    }

}
