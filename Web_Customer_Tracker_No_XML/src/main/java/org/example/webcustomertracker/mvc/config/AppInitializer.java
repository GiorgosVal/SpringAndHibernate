package org.example.webcustomertracker.mvc.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Objects;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);                                          // register configuration class
       // context.setConfigLocation("org.example.webcustomertracker.mvc.config");   // or entire package

        // bind somehow the context with servletContext
        servletContext.addListener(new ContextLoaderListener(context));     // Baeldung way
        //context.setServletContext(servletContext);                        // another way?


        DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcherSe", dispatcherServlet);

        System.out.println("Added servlet. isNull" + Objects.isNull(servlet));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");

    }
}
