package ru.korus.tmis.pdm.model;

import java.util.List;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        15.10.2014, 17:51 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
public class PdmSystems {

    private List<PdmSystemInfo> systems;

    private PdmSystemInfo newSystem;

    public List<PdmSystemInfo> getSystems() {
        return systems;
    }

    public void setSystems(List<PdmSystemInfo> systems) {
        this.systems = systems;
    }

    public PdmSystemInfo getNewSystem() {
        return newSystem;
    }

    public void setNewSystem(PdmSystemInfo newSystem) {
        this.newSystem = newSystem;
    }
}
