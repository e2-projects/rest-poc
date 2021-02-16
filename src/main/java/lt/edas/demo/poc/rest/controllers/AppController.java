package lt.edas.demo.poc.rest.controllers;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import lt.edas.demo.poc.services.person.PersonService;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class AppController implements AppMapping {

    private final PersonService service;

    @Override
    public void ping() { }

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
