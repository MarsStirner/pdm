package ru.korus.tmis.pdm;

import java.io.Serializable;
import java.util.List;
import java.util.Vector;


import javax.xml.bind.JAXBElement;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ru.korus.tmis.pdm.ws.CE;
import ru.korus.tmis.pdm.ws.EnFamily;
import ru.korus.tmis.pdm.ws.EnGiven;
import ru.korus.tmis.pdm.ws.II;
import ru.korus.tmis.pdm.ws.PN;
import ru.korus.tmis.pdm.ws.PRPAIN101311UV02;
import ru.korus.tmis.pdm.ws.PRPAMT101301UV02OtherIDs;
import ru.korus.tmis.pdm.ws.PRPAMT101301UV02Person;
import ru.korus.tmis.pdm.ws.TS;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        02.07.2013, 12:35:19 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

/**
 * 
 */
@Document(collection = "users")
public class PersonalData {

	/**
     * Пол пациента
     */
    public static class Term {
        private final String code;
        private final String codeSystem;
    	private Term(String code, String codeSystem) {
    		this.code = code;
    		this.codeSystem = codeSystem;
    	}
    }

    /**
     * Уникальный идентификатор субъекта ПДн в ЗХПД
     */
     @Id
     private String id;

    /**
     * Имя
     */
    final private String given;
    
     /**
     * Отчество 
     */
    final private String middleName;
    
    /**
     * Фамилия
     */
    final private String family;
    
    /**
     * Пол
     */
    final private Term gender; 

    /**
     * Дата рождения в фомате yyyyMMdd 
     */
    final private String birthData;
    
    /**
     * Документы: 
     * Документ, удостоверяющий личность; 
     * ИНН; 
     * Номер полиса обязательного медицинского страхования; 
     * Документ, удостоверяющий временную нетрудоспособность; 
     * Документ об образовании  
     */
    final private Vector<Term> docs = new Vector<Term>();
    
   
	/**
     * @param parameters
     */
    public PersonalData(PRPAIN101311UV02 prm, WebServiceContext wsContext) {
        id = null;
        String family = null;
        PRPAMT101301UV02Person identifiedPerson = prm.getControlActProcess().getSubject().getRegistrationRequest().getSubject1().getIdentifiedPerson().getIdentifiedPerson();
        

        this.given = getNameAttr(wsContext, "given", 0); 
        this.middleName = getNameAttr(wsContext, "given", 1); 
        this.family = getNameAttr(wsContext, "family"); 
        CE administrativeGenderCode = identifiedPerson.getAdministrativeGenderCode();
        Term gender = null;
        if (administrativeGenderCode != null) {
        	gender = new Term(administrativeGenderCode.getCode(), administrativeGenderCode.getCodeSystem());
        }
        this.gender = gender;
        String birthData = null;
        TS birthTime = identifiedPerson.getBirthTime();
        if (birthTime != null) {
        	birthData = birthTime.getValue();
        } 
        this.birthData = birthData;
        for (PRPAMT101301UV02OtherIDs ids : identifiedPerson.getAsOtherIDs()) {
        	for(II ii : ids.getId() ) {
        		docs.add(new Term(ii.getExtension(), ii.getRoot()));
        	}
        }
    }
    
    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

     private String getNameAttr(WebServiceContext wsContext, String attrName) {
         return getNameAttr(wsContext, attrName, 0);
     }

    String tmp;
    
    private String getNameAttr(WebServiceContext wsContext, String attrName, int index) {
        String res = "";
        /*tmp = wsContext.getMessageContext().getClass().getName();
        SOAPMessageContext msgContext = (SOAPMessageContext)wsContext.getMessageContext();
        SOAPMessage soapMessage = msgContext.getMessage();
        SOAPBody soapBody = soapMessage.getSOAPBody();
        Element elName = getChildByName(soapBody, "name");
        NodeList nodeList = elName.getElementsByTagName(attrName);
        if (index < nodeList.getLength()) {
            res = nodeList.item(index).getTextContent();
        } */
        return res;
    }
    
    private Element getChildByName(Element parent, String name)
    {
        for(Node child = parent.getFirstChild(); child != null; child = child.getNextSibling())
        {
            if(child instanceof Element && name.equals(child.getNodeName())) {
                return (Element) child;
            }
        }
        return null;
    }

}
