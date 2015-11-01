package ru.dmitry.postrequest;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.dmitry.postrequest.services.CountryService;
import ru.dmitry.postrequest.utils.Request;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        Request request = context.getBean("testRequest", Request.class);
        CountryService countryService = context.getBean(CountryService.class);
        countryService.sendRequest(request);
    }
}
