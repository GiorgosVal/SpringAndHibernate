package org.example.springsecuritydemo.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@PropertySource(value = "classpath:application.properties")
public class DataSourceConfig {

    @Autowired
    private Environment environment;
    private Logger logger = Logger.getLogger(getClass().getSimpleName());

    @Bean
    public DataSource securityDataSource() {
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try {
            dataSource.setDriverClass(environment.getProperty("jdbc.driver"));
        } catch (PropertyVetoException e) {
            logger.severe(e.toString());
        }

        logger.info("> jdbc.url=" + environment.getProperty("jdbc.url"));
        logger.info("> jdbc.user=" + environment.getProperty("jdbc.user"));

        dataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
        dataSource.setUser(environment.getProperty("jdbc.user"));
        dataSource.setPassword(environment.getProperty("jdbc.password"));

        dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));
        dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));
        dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));
        dataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

        return dataSource;
    }
}
