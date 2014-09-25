package ru.korus.tmis.pdm.ws;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        13.11.13, 15:23 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmSysProperties {
    public static final String PDM_STORAGE_TYPE = "pdm.StorageType";
    public static final String PDM_CONFIG_FILE = "pdm.ConfigFile";
    public static final String PDM_ALEE_URL = "pdm.AleeUrl";

    public static class Value {
        public static final String STORAGE_TYPE_ALEE = "alee";
        public static final String DEFAULT_CONFIG_FILE = "pdm_config.xml";
        public static final String DEFAULT_ALEE_URL = "10.129.188.20";
    }

    public static String getPdmStorageType() {
        return System.getProperty(PdmSysProperties.PDM_STORAGE_TYPE, "");
    }

    public static String getConfigFileName() {
        return System.getProperty(PdmSysProperties.PDM_CONFIG_FILE, PdmSysProperties.Value.DEFAULT_CONFIG_FILE);
    }

    public static String getAleeUrl() {
        return System.getProperty(PdmSysProperties.PDM_ALEE_URL, PdmSysProperties.Value.DEFAULT_ALEE_URL);
    }
}
