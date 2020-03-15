package org.example.springmvcdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@Controller
public class HelloWorldController {

    @RequestMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        System.out.println("AuthType: " + request.getAuthType());
        System.out.println("Header - User-Agent: " + request.getHeader("User-Agent"));
        System.out.println("Header - Host: " + request.getHeader("Host"));
        System.out.println("ContextPath " + request.getContextPath());
        System.out.println("Method: " + request.getMethod());
        System.out.println("Path info: " + request.getPathInfo());
        System.out.println("Query String: " + request.getQueryString());
        System.out.println("Remote user: " + request.getRemoteUser());
        System.out.println("Requested Session Id: " + request.getRequestedSessionId());
        System.out.println("Request URI: " + request.getRequestURI());
        System.out.println("Servlet path: " + request.getServletPath());
        System.out.println("Protocol: " + request.getProtocol());
        System.out.println("Cookies array: " + request.getCookies().toString());
        Arrays.stream(request.getCookies()).forEach(cookie -> {
            System.out.println("Cookie: " + cookie.getName() + ", value: " + cookie.getValue());
        });


        String name = request.getParameter("studentName");
        name = name.toUpperCase();

        String result = "Yo! " + name;
        model.addAttribute("message", result);
        return "helloworld";
    }

    /*
    The @RequestParam("studentName") String name, is the same as using the HttpServletRequest and getting the parameter
    from it (as done in the controller processFormVersionTwo).
     */
    @RequestMapping("/processFormVersionThree")
    public String letsShoutDude(@RequestParam("studentName") String name, Model model) {
        String result = "Hello with @RequestParam! " + name.toUpperCase();
        model.addAttribute("message", result);
        return "helloworld";
    }

}
