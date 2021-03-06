package ru.korus.tmis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;
import ru.korus.tmis.pdm.config.PdmSpringConfiguration;
import ru.korus.tmis.pdm.service.AuthService;

import static org.testng.Assert.*;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        29.09.2014, 17:13 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */
@ContextConfiguration(classes = { PdmSpringConfiguration.class })
@WebAppConfiguration
public class AuthServiceTest extends AbstractTestNGSpringContextTests {

    @Autowired
    AuthService authService;

    @Test
    public void testCreateToken() {
        String res = authService.createToken("wrong", "pass");
        assertNull(res);
        res = authService.createToken("a", "a");
        assertFalse(res.isEmpty());
    }
}
