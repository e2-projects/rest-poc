package lt.edas.demo.poc.rest.controllers;

import io.swagger.annotations.ApiOperation;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping
interface AppMapping {

    String PING = "/ping";
    String PERSON = "/person";

    @GetMapping(PING)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void ping(HttpServletRequest request);

    @PostMapping(PERSON)
    @ApiOperation(
            value = "Create Person",
            notes = "<b>New person creation.</b><br>" +
                    "Required params:<br>" +
                    "<ul>" +
                    "<li>Name</li>" +
                    "<li>Surname</li>" +
                    "<li>Email</li>" +
                    "</ul>" +
                    "<b>Returns:</b> ID"
            )
    Long createPerson(@RequestBody CreatePersonRequest request);

    @GetMapping(PERSON)
    @ApiOperation(
            value = "Search person",
            notes = "<b>Search person by name or surname.</b><br>" +
                    "<b>Default param: \"\"</b>" +
                    "<b>Returns:</b> Object with list of people"
    )
    SearchResponse getPersons(
            @RequestParam(defaultValue = "")
            String nameContext
    );

    @PutMapping(PERSON)

    @ApiOperation(
            value = "Update person parameters",
            notes = "<b>Update created person by ID.</b><br>" +
                    "Required params:<br>" +
                    "<ul>" +
                    "<li>ID</li>" +
                    "</ul>" +
                    "<b>Returns:</b> id"
    )
    void updatePerson(@RequestBody UpdatePersonRequest request);
}
