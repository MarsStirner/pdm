package ru.korus.tmis.pdm.test.utilities;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import ru.korus.tmis.pdm.utilities.Xml;

import static org.testng.Assert.assertEquals;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        08.11.13, 9:58 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class XmlTest {

    /**
     * Проверка методов Xml.getElementValue и Xml.getAttrValue
     */
    @Test
    public void getElementAndAttrValue() {
        String xmlString = "<?xml version=\"1.0\"?>\n" +
                "<Employees>\n" +
                "    <Employee emplid=\"1111\" type=\"admin\">\n" +
                "        <firstname>John</firstname>\n" +
                "        <lastname>Watson</lastname>\n" +
                "        <age>30</age>\n" +
                "        <email>johnwatson@sh.com</email>\n" +
                "    </Employee>\n" +
                "    <Employee emplid=\"2222\" type=\"admin\">\n" +
                "        <firstname>Sherlock</firstname>\n" +
                "        <lastname>Homes</lastname>\n" +
                "        <age>32</age>\n" +
                "        <email>sherlock@sh.com</email>\n" +
                "    </Employee>\n" +
                "    <Employee emplid=\"3333\" type=\"user\">\n" +
                "        <firstname>Jim</firstname>\n" +
                "        <lastname>Moriarty</lastname>\n" +
                "        <age>52</age>\n" +
                "        <email>jim@sh.com</email>\n" +
                "    </Employee>\n" +
                "    <Employee emplid=\"4444\" type=\"user\">\n" +
                "        <firstname>Mycroft</firstname>\n" +
                "        <lastname>Holmes</lastname>\n" +
                "        <age>41</age>\n" +
                "        <email>mycroft@sh.com</email>\n" +
                "    </Employee>\n" +
                "</Employees>";
        Document doc = Xml.loadString(xmlString);
        final String expressionElement = "/Employees/Employee[@emplid='3333']/email";
        final String valueElement = Xml.getElementValue(doc, expressionElement);
        assertEquals(valueElement, "jim@sh.com");

        String expressionAttr = "/Employees/Employee[@emplid='3333']/@emplid";
        final String valueAttr = Xml.getAttrValue(doc, expressionAttr);
        assertEquals(valueAttr, "3333");
    }
}
