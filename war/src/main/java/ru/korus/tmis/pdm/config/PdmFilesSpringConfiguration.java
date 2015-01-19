package ru.korus.tmis.pdm.config;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import ru.korus.tmis.pdm.controller.AuthInterceptor;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "pdmFileEntityManagerFactory",
        transactionManagerRef = "pdmFileTransactionManager",
        basePackages = { "ru.korus.tmis.pdm.repositories.pdmfiles" })
public class PdmFilesSpringConfiguration  {

    @Bean(name = "pdmFileDataSource")
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(PdmSpringConfiguration.dataBaseType.getDriver());
        dataSource.setUrl(PdmSpringConfiguration.dataBaseType.getUrlFiles());

        dataSource.setUsername(PdmSpringConfiguration.PROPERTY_NAME_DATABASE_USERNAME);
        dataSource.setPassword(PdmSpringConfiguration.PROPERTY_NAME_DATABASE_PASSWORD);

        return dataSource;
    }

    @Bean(name = "pdmFileEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(PdmSpringConfiguration.PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN + ".pdmfiles");
        entityManagerFactoryBean.setJpaProperties(PdmSpringConfiguration.hibProperties(PdmSpringConfiguration.dataBaseType.getUrlFiles()));

        return entityManagerFactoryBean;
    }

    @Bean(name = "pdmFileTransactionManager")
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}
