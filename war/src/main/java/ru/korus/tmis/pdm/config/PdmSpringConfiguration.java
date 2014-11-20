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
@ComponentScan(basePackages = "ru.korus.tmis.pdm")
@EnableWebMvc
@EnableJpaRepositories("ru.korus.tmis.pdm.repositories")
public class PdmSpringConfiguration extends WebMvcConfigurerAdapter {

    /*** Spring Data JPA config **************************************************************************************/
    private static final String PROPERTY_NAME_DATABASE_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private static final String PROPERTY_NAME_DATABASE_URL_MYSQL = "jdbc:mysql://localhost:3306/pdm?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";

    private static final String PROPERTY_NAME_DATABASE_DRIVER_POSTGRESQL = "org.postgresql.Driver\n";
    private static final String PROPERTY_NAME_DATABASE_URL_POSTGRESQL = "jdbc:postgresql://localhost:5432/pdm";

    private static final String PROPERTY_NAME_DATABASE_USERNAME = "root";
    private static final String PROPERTY_NAME_DATABASE_PASSWORD = "root";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT_MYSQL = "org.hibernate.dialect.MySQL5InnoDBDialect";

    private static final String PROPERTY_NAME_HIBERNATE_DIALECT_POSTGRESQL = "org.hibernate.dialect.PostgreSQLDialect";

    private static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "ru.korus.tmis.pdm.entities";

    public enum DataBaseType {

        POSTGRESQL(PROPERTY_NAME_DATABASE_DRIVER_POSTGRESQL,
                PROPERTY_NAME_DATABASE_URL_POSTGRESQL,
                PROPERTY_NAME_HIBERNATE_DIALECT_POSTGRESQL),

        MYSQL(PROPERTY_NAME_DATABASE_DRIVER_MYSQL,
                PROPERTY_NAME_DATABASE_URL_MYSQL,
                PROPERTY_NAME_HIBERNATE_DIALECT_MYSQL);

        private final String driver;

        private final String url;

        private final String dialect;

        DataBaseType(String driver, String url, String dialect) {
            this.driver = driver;
            this.url = url;
            this.dialect = dialect;
        }
    }

    public static final DataBaseType dataBaseType = DataBaseType.MYSQL;

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor);
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName(dataBaseType.driver);
        dataSource.setUrl(dataBaseType.url);

        dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
        dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);

        return dataSource;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();

        entityManagerFactoryBean.setDataSource(dataSource());
        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
        entityManagerFactoryBean.setJpaProperties(hibProperties());

        return entityManagerFactoryBean;
    }

    private Properties hibProperties() {
        Properties properties = new Properties();

        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", dataBaseType.dialect);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.globally_quoted_identifiers", "true");
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("hibernate.connection.characterEncoding", "UTF-8");
        properties.put("hibernate.connection.charSet", "UTF-8");

        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}
