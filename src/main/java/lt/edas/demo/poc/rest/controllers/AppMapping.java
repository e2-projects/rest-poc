package lt.edas.demo.poc.rest.controllers;

import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController()
@RequestMapping()
public interface AppMapping {

    String PING = "/ping";
    String PERSON = "/person";

    @GetMapping(PING)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void ping(HttpServletRequest request);

    @PostMapping(PERSON)
    void createPerson(CreatePersonRequest request);

    @GetMapping(PERSON)
    SearchResponse getPersons();

    @PutMapping(PERSON)
    void updatePerson(Object request);
}
