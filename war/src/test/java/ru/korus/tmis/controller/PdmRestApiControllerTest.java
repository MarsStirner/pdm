package ru.korus.tmis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.web.context.WebApplicationContext;
import org.testng.annotations.Test;
import ru.korus.tmis.pdm.config.PdmSpringConfiguration;
import ru.korus.tmis.pdm.config.SpringMongoConfig;
import ru.korus.tmis.pdm.model.api.SystemLogin;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertEquals;

/**
 * Author:      Sergey A. Zagrebelny <br>
 * Date:        03.08.2015, 15:45 <br>
 * Company:     Korus Consulting IT<br>
 * Description:  <br>
 */

@ContextConfiguration(classes = {PdmSpringConfiguration.class, SpringMongoConfig.class})
@WebAppConfiguration
public class PdmRestApiControllerTest extends AbstractTestNGSpringContextTests {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Test
    public void login() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        String url = "/api/login";
        ResultActions resultAction = myMockPost(url, "loginReq.json");
        MvcResult result = getResult(url, resultAction);
        resultAction.andExpect( jsonPath("$.id").exists());
        int httpStatus = HttpStatus.OK.value();
        assertEquals(result.getResponse().getStatus(), httpStatus);
    }

    @Test
    public void loginError() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
        String url = "/api/login";
        ResultActions resultAction = myMockPost(url, "loginReqError.json");
        MvcResult result = getResult(url, resultAction);
        resultAction.andExpect( jsonPath("$.status").exists());
        int httpStatus = HttpStatus.FORBIDDEN.value();
        assertEquals(result.getResponse().getStatus(), httpStatus);
    }


    private ResultActions myMockPost(String urlTemplate, String fileReqName) throws Exception {
        String basePath = "./war/src/test/resourses/json/";
        String data = new String(Files.readAllBytes(Paths.get(basePath + fileReqName)));
        MockHttpServletRequestBuilder mockHttpServletRequestBuilder = MockMvcRequestBuilders.post(urlTemplate);
        ResultActions result =mockMvc.perform(mockHttpServletRequestBuilder.contentType(MediaType.APPLICATION_JSON)
                .content(data));

        getResult(urlTemplate, result);
        return result;
    }

    private MvcResult getResult(String urlTemplate, ResultActions result) throws UnsupportedEncodingException {
        MvcResult mvcResult = result.andReturn();
        String res = mvcResult.getResponse().getContentAsString();
        System.out.println("************ " + urlTemplate + ": " + res);
        return mvcResult;
    }

}
