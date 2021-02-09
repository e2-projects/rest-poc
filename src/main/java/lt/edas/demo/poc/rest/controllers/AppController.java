package lt.edas.demo.poc.rest.controllers;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import lt.edas.demo.poc.services.person.PersonService;
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
    public Long createPerson(CreatePersonRequest request) {
        return service.createPerson(request);
    }

    @Override
    public SearchResponse getPersons(String nameContext) {
        return service.getPersons(nameContext);
    }

    @Override
    public void updatePerson(UpdatePersonRequest request) {
        service.updatePerson(request);
    }

}
