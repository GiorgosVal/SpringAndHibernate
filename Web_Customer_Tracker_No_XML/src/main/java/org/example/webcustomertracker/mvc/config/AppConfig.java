package org.example.webcustomertracker.mvc.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc
@ComponentScan(basePackages = "org.example.webcustomertracker")
@PropertySource(value = "classpath:application.properties")
public class AppConfig implements WebMvcConfigurer {

//    @Autowired
//    private Environment environment;

    /**
     * Replaces the <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver"> part of Spring's xml configuration
     * @return
     */
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/view");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    /**
     * Replaces the <mvc:resources location="/static/" mapping="/static/**"/> part of Spring's xml configuration
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("/static/");
    }


//    // HIBERNATE CONFIGURATION
//
//    /**
//     * Replaces the <bean id="myDataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" destroy-method="close">
//     * @return
//     */
//    @Bean
//    public DataSource myDataSource() {
//
//        // create the connection pool
//        ComboPooledDataSource myDataSource = new ComboPooledDataSource();
//
//        // set the JDBC driver
//        try {
//            myDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
//        } catch (PropertyVetoException e) {
//            e.printStackTrace();
//        }
//
//        // set the database connection properties
//        myDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
//        myDataSource.setUser(environment.getProperty("jdbc.user"));
//        myDataSource.setPassword(environment.getProperty("jdbc.password"));
//
//        // set the connection pool properties
//        myDataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
//        myDataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
//        myDataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
//        myDataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));
//
//        return myDataSource;
//    }
//
//    /**
//     * Replaces the <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
//     * @return
//     */
//    @Bean
//    public LocalSessionFactoryBean sessionFactory() {
//        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
//        sessionFactory.setDataSource(myDataSource());
//        sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
//        sessionFactory.setHibernateProperties(getHibernateProperties());
//
//        return sessionFactory;
//    }
//
//    /**
//     * Util method to retrieve Hibernate properties.
//     * @return
//     */
//    private Properties getHibernateProperties() {
//        Properties properties = new Properties();
//        properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
//        properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
//        properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql"));
//
//        return properties;
//    }
//
//    /**
//     * Replaces the <bean id="myTransactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
//     * @param sessionFactory
//     * @return
//     */
//    @Bean
//    @Autowired
//    public HibernateTransactionManager myTransactionManager(SessionFactory sessionFactory) {
//        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
//        transactionManager.setSessionFactory(sessionFactory);
//        return transactionManager;
//    }






}
