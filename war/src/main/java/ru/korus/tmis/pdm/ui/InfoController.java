package ru.korus.tmis.pdm.ui;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.korus.tmis.pdm.PdmSysProperties;

@Controller
@RequestMapping("/info")
public class InfoController {

    @RequestMapping(method = RequestMethod.GET)
    public String printWelcome(ModelMap model) {
        //model.addAttribute("storageType", PdmSysProperties.getPdmStorageType());
        //model.addAttribute("configFile", PdmSysProperties.getConfigFileName());
        return "info";
    }
}
