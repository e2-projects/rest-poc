package lt.edas.demo.poc.rest.controllers;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import lt.edas.demo.poc.services.interfaces.PersonService;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
public class AppController implements AppMapping {

    private final Logger logger;
    private final PersonService service;

    @Override
    public void ping(HttpServletRequest request) {
        logger.info("Connected from {}", request.getRemoteAddr());
    }

    @Override
    public void createPerson(CreatePersonRequest request) {
        service.createPerson(request);
    }

    @Override
    public SearchResponse getPersons() {
        return null;
    }

    @Override
    public void updatePerson(Object request) {

    }

}
