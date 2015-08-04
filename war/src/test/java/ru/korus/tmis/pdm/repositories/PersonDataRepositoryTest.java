package ru.korus.tmis.pdm.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;
import ru.korus.tmis.pdm.config.PdmSpringConfiguration;
import ru.korus.tmis.pdm.config.SpringMongoConfig;
import ru.korus.tmis.pdm.entities.pdm.Addresses;
import ru.korus.tmis.pdm.entities.pdm.Person;
import ru.korus.tmis.pdm.repositories.pdm.PersonDataRepository;
import ru.korus.tmis.pdm.utilities.Crypting;

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
    PersonDataRepository personDataRepository;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void testSave() {
        Person personalData = new Person();

        personalData.setFamily("Фамилия");
        personalData.setGiven("Имя");
        personalData.setMiddleName("Отчесво");
        personalData.setGender(Crypting.getSecureRandomBytes(8));
        personalData.setBirthInfo(Crypting.getSecureRandomBytes(8));

        Addresses addr = new Addresses(Crypting.getSecureRandomBytes(8));
        personalData.getAddress().add(addr);

        personDataRepository.save(personalData);
        assertNotNull(personalData.getId());
    }
}
