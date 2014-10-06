package ru.korus.tmis.pdm.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.korus.tmis.pdm.controller.AuthInterceptor;
import ru.korus.tmis.pdm.service.PdmDaoService;

@Configuration
@ComponentScan(basePackages = "ru.korus.tmis.pdm")
@EnableWebMvc
public class PdmSpringConfiguration extends WebMvcConfigurerAdapter {


    @Autowired
    private AuthInterceptor authInterceptor;

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

 //   @Bean
   // public PdmDaoService getPdmDaoService() {
     //   return mongo;
/*
            if (PdmSysProperties.getPdmStorageType().equals(PdmSysProperties.Value.STORAGE_TYPE_POSTGRESQL)) {
                storageOperations = new AleePdmOperations();
            } else {
                storageOperations =
            }
*/
   // }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }
}
