package ru.korus.tmis.pdm.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import ru.korus.tmis.pdm.config.PdmSpringConfiguration;
import ru.korus.tmis.pdm.config.SpringMongoConfig;
import ru.korus.tmis.pdm.entities.Addr;
import ru.korus.tmis.pdm.entities.PersonalData;
import ru.korus.tmis.pdm.entities.Term;

import static org.testng.Assert.assertNotNull;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        07.10.2014, 12:49 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@ContextConfiguration(classes = {PdmSpringConfiguration.class, SpringMongoConfig.class})
@WebAppConfiguration
public class PersonDataRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    PersonDataRepository  personDataRepository;

    @Test
    public void testSave() {
        PersonalData personalData = new PersonalData();
        personalData.setFamily("Репо");
        personalData.setGiven("Инфо");
        personalData.setMiddleName("Отчесво");
        Term gender = new Term();
        //gender.
        personalData.setGender(gender);
        Addr addr = new Addr();
        personalData.setBirthPlace(addr);
        Addr addr1 = new Addr();
        personalData.getAddress().add(addr1);
        personDataRepository.save(personalData);
        assertNotNull(personalData.getId());
    }
}
