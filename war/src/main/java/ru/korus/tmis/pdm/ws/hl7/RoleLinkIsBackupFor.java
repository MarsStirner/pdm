
package ru.korus.tmis.pdm.ws.hl7;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RoleLinkIsBackupFor.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="RoleLinkIsBackupFor">
 *   &lt;restriction base="{urn:hl7-org:v3}cs">
 *     &lt;enumeration value="BACKUP"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "RoleLinkIsBackupFor")
@XmlEnum
public enum RoleLinkIsBackupFor {

    BACKUP;

    public String value() {
        return name();
    }

    public static RoleLinkIsBackupFor fromValue(String v) {
        return valueOf(v);
    }

}
