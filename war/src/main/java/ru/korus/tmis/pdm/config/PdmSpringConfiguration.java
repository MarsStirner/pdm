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
@EnableJpaRepositories("ru.korus.tmis.pdm.repositories.pdm")
public class PdmSpringConfiguration extends WebMvcConfigurerAdapter {

    /*** Spring Data JPA config **************************************************************************************/
    public static final String PROPERTY_NAME_DATABASE_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    public static final String PROPERTY_NAME_DATABASE_URL_MYSQL = "jdbc:mysql://localhost:3306/pdm?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8";

    public static final String PROPERTY_NAME_DATABASE_DRIVER_POSTGRESQL = "org.postgresql.Driver\n";

    public static final String DATABASE_HOST = System.getProperty("pdm.database.host", "localhost:5432");
    public static final String PDM = System.getProperty("pdm.database.name","pdm");
    public static final String PROPERTY_NAME_DATABASE_URL_POSTGRESQL = "jdbc:postgresql://" + DATABASE_HOST + "/" + PDM;
    public static final String PROPERTY_NAME_DATABASE_USERNAME = System.getProperty("pdm.database.username","root");
    public static final String PROPERTY_NAME_DATABASE_PASSWORD = System.getProperty("pdm.database.password","root");;

/*    public static final String PROPERTY_NAME_DATABASE_URL_POSTGRESQL = "jdbc:postgresql://localhost:5432/zhpd";
    public static final String PROPERTY_NAME_DATABASE_USERNAME = "tmis";
    public static final String PROPERTY_NAME_DATABASE_PASSWORD = "q1w2e3r4t5";*/

    public static final String PROPERTY_NAME_HIBERNATE_DIALECT_MYSQL = "org.hibernate.dialect.MySQL5InnoDBDialect";

    public static final String PROPERTY_NAME_HIBERNATE_DIALECT_POSTGRESQL = "org.hibernate.dialect.PostgreSQLDialect";

    public static final String PROPERTY_NAME_HIBERNATE_SHOW_SQL = "true";
    public static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = "ru.korus.tmis.pdm.entities";

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

        public String getDriver() {
            return driver;
        }

        public String getUrl() {
            return url;
        }

        public String getUrlFiles() {
            return url + "_files";
        }

        public String getDialect() {
            return dialect;
        }
    }

    public static final DataBaseType dataBaseType = DataBaseType.POSTGRESQL;

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
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN + ".pdm");
        entityManagerFactoryBean.setJpaProperties(hibProperties(dataBaseType.url));

        return entityManagerFactoryBean;
    }

    public static Properties hibProperties(String url) {
        Properties properties = new Properties();

        properties.put("hibernate.hbm2ddl.auto", "update");
        properties.put("hibernate.dialect", dataBaseType.dialect);
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.globally_quoted_identifiers", "true");
        properties.put("hibernate.connection.useUnicode", "true");
        properties.put("hibernate.connection.characterEncoding", "UTF-8");
        properties.put("hibernate.connection.charSet", "UTF-8");

        properties.put("hibernate.connection.url", url );
        properties.put("hibernate.connection.username", PROPERTY_NAME_DATABASE_USERNAME);
        properties.put("hibernate.connection.password", PROPERTY_NAME_DATABASE_PASSWORD);

        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        properties.put("hibernate.auto_close_session", "true");
        properties.put("hibernate.connection.provider_class", "org.hibernate.connection.C3P0ConnectionProvider");
        properties.put("hibernate.c3p0.acquire_increment", 5);
        properties.put("hibernate.c3p0.idle_test_period", 1800);
        properties.put("hibernate.c3p0.max_size", 600);
        properties.put("hibernate.c3p0.max_statements", 50);
        properties.put("hibernate.c3p0.min_size", 5);
        properties.put("hibernate.c3p0.timeout", 1800);
        properties.put("hibernate.c3p0.numHelperThreads", 10);
        properties.put("hibernate.c3p0.maxAdministrativeTaskTime", 15);

        return properties;
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager();

        transactionManager.setEntityManagerFactory(entityManagerFactory().getObject());

        return transactionManager;
    }

}
