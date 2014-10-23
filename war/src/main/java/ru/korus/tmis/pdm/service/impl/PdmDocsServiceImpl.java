package ru.korus.tmis.pdm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.korus.tmis.pdm.model.PdmAttrInfo;
import ru.korus.tmis.pdm.model.PdmDocs;
import ru.korus.tmis.pdm.model.PdmDocsInfo;
import ru.korus.tmis.pdm.service.PdmDocsService;
import ru.korus.tmis.pdm.service.PdmXmlConfigService;
import ru.korus.tmis.pdm.service.impl.xml.PdmConfig;

import java.util.LinkedList;
import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        20.10.2014, 18:59 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@Service
public class PdmDocsServiceImpl implements PdmDocsService {

    @Autowired
    PdmXmlConfigService pdmXmlConfigService;

    @Override
    public PdmDocs getDocsInfo() {
        PdmDocs res = new PdmDocs();
        List<PdmConfig.Docs.Doc> docs = pdmXmlConfigService.getDocs();
        res.setDocs(new LinkedList<PdmDocsInfo>());
        for (PdmConfig.Docs.Doc doc : docs) {
            PdmDocsInfo pdmDocsInfo = new PdmDocsInfo();
            pdmDocsInfo.setName(doc.getName());
            pdmDocsInfo.setDescription(doc.getDescription());
            pdmDocsInfo.setNewName(doc.getName());
            pdmDocsInfo.setNewDescription(doc.getDescription());
            initAttr(pdmDocsInfo, doc.getAttribute());
            res.getDocs().add(pdmDocsInfo);
        }
        return res;
    }

    @Override
    public boolean addDoc(PdmDocsInfo newDoc) {
        if (pdmXmlConfigService.getDocByName(newDoc.getName()) == null
                && newDoc.getName() != null
                && !newDoc.getName().isEmpty()) {
            PdmConfig.Docs.Doc doc = PdmXmlConfigServiceImpl.getPdmXlmFactory().createPdmConfigDocsDoc();
            pdmXmlConfigService.getDocs().add(doc);

            doc.setName(newDoc.getName());
            doc.setDescription(newDoc.getDescription());
            PdmConfig.Docs.Doc.Attribute newAttr = new PdmConfig.Docs.Doc.Attribute();
            newAttr.setDescription("Введите наименование нового атрибута!");
            newAttr.setOid("Введите новый OID атрибута в '" + newDoc.getName() + "'!");
            newAttr.setName("Введите код!");
            doc.getAttribute().add(newAttr);

            pdmXmlConfigService.initObjectMap();
        }
        return false;
    }

    @Override
    public boolean updateDocs(PdmDocsInfo pdmDocsInfo) {
        final String name = pdmDocsInfo.getName();
        boolean isUpdate = false;
        PdmConfig.Docs.Doc doc = pdmXmlConfigService.getDocByName(name);
        if (pdmDocsInfo.getNewName() != null
                && !name.equals(pdmDocsInfo.getNewName())
                && pdmXmlConfigService.getDocByName(pdmDocsInfo.getNewName()) != null) {
            // если код документа уже используется
            return false;
        }
        if (pdmDocsInfo.getNewName() != null && !pdmDocsInfo.getNewName().isEmpty()) {
            doc.setName(pdmDocsInfo.getNewName());
            isUpdate = true;
        }
        if (pdmDocsInfo.getNewDescription() != null && !pdmDocsInfo.getNewDescription().isEmpty()) {
            doc.setDescription(pdmDocsInfo.getNewDescription());
            isUpdate = true;
        }
        return pdmXmlConfigService.saveIfNeeded(isUpdate);
    }

    @Override
    public boolean updateAttr(PdmDocsInfo pdmDocsInfo, Integer attrIndex) {
        final String name = pdmDocsInfo.getName();
        pdmDocsInfo.getAttrs().get(attrIndex);
        boolean isUpdate = false;
        PdmConfig.Docs.Doc doc = pdmXmlConfigService.getDocByName(name);
        if (doc != null
                && attrIndex < doc.getAttribute().size()
                && attrIndex < pdmDocsInfo.getAttrs().size()) {
            List<PdmConfig.Docs.Doc.Attribute> attributes = doc.getAttribute();
            PdmConfig.Docs.Doc.Attribute attribute = attributes.get(attrIndex);
            PdmAttrInfo pdmAttrInfo = pdmDocsInfo.getAttrs().get(attrIndex);
            String newOid = pdmAttrInfo.getNewOid();
            String newName = pdmAttrInfo.getNewName();
            if (checkAttrNewOid(newOid, attribute) &&
                    checkAttrNewName(newName, attributes, attribute)) {
                attribute.setOid(newOid);
                attribute.setName(newName);
                attribute.setDescription(pdmAttrInfo.getNewDescription());
                return pdmXmlConfigService.saveIfNeeded(true);
            }
        }
        return false;
    }

    @Override
    public boolean deleteAttr(String docName, Integer attrIndex) {
        PdmConfig.Docs.Doc doc = pdmXmlConfigService.getDocByName(docName);
        if (doc != null
                && attrIndex < doc.getAttribute().size()
                && doc.getAttribute().size() > 1 ) {
            List<PdmConfig.Docs.Doc.Attribute> attributes = doc.getAttribute();
            attributes.remove((int)attrIndex);
            return pdmXmlConfigService.saveIfNeeded(true);
        }
        return false;
    }

    @Override
    public boolean addAttr(PdmDocsInfo pdmDocsInfo) {
        PdmAttrInfo newAttrInfo = pdmDocsInfo.getNewAttr();
        if(pdmXmlConfigService.getObjectByOid(newAttrInfo.getNewOid()) == null) {
            PdmConfig.Docs.Doc doc = pdmXmlConfigService.getDocByName(pdmDocsInfo.getName());
            if(doc != null) {
                PdmConfig.Docs.Doc.Attribute newAttr = new PdmConfig.Docs.Doc.Attribute();
                newAttr.setName(newAttrInfo.getNewName());
                newAttr.setDescription(newAttrInfo.getNewDescription());
                newAttr.setOid(newAttrInfo.getNewOid());
                doc.getAttribute().add(newAttr);
                return pdmXmlConfigService.saveIfNeeded(true);
            }
        }
        return false;
    }

    private boolean checkAttrNewOid(String newOid, PdmConfig.Docs.Doc.Attribute attribute) {
        if (newOid == null) {
            return false;
        }
        if (newOid.equals(attribute.getOid())) {
            return true;
        }
        return (Object) pdmXmlConfigService.getObjectByOid(newOid) == null;
    }

    private boolean checkAttrNewName(String newName, List<PdmConfig.Docs.Doc.Attribute> attributes, PdmConfig.Docs.Doc.Attribute attribute) {
        if (newName == null) {
            return false;
        }
        if (newName.equals(attribute.getName())) {
            return true;
        }
        for (PdmConfig.Docs.Doc.Attribute a : attributes) {
            if (a.getName().equals(newName)) {
                return false;
            }
        }
        return true;
    }


    @Override
    public boolean deleteDoc(String name) {
        boolean isUpadate = false;
        PdmConfig.Docs.Doc doc = pdmXmlConfigService.getDocByName(name);
        if (doc != null) {
            pdmXmlConfigService.getDocs().remove(doc);
            return pdmXmlConfigService.saveIfNeeded(true);
        }
        return false;
    }


    private void initAttr(PdmDocsInfo pdmDocsInfo, List<PdmConfig.Docs.Doc.Attribute> attributes) {
        pdmDocsInfo.setAttrs(new LinkedList<PdmAttrInfo>());
        for (PdmConfig.Docs.Doc.Attribute attr : attributes) {
            PdmAttrInfo attrInfo = new PdmAttrInfo();
            attrInfo.setName(attr.getName());
            attrInfo.setDescription(attr.getDescription());
            attrInfo.setOid(attr.getOid());
            attrInfo.setNewName(attr.getName());
            attrInfo.setNewDescription(attr.getDescription());
            attrInfo.setNewOid(attr.getOid());
            pdmDocsInfo.getAttrs().add(attrInfo);
        }
    }


}
