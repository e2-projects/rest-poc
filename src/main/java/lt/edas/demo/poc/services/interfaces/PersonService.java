package lt.edas.demo.poc.services.interfaces;

import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;

public interface PersonService {

    Long createPerson(CreatePersonRequest request);

    SearchResponse getPersons(String searchParam);

    void updatePerson(UpdatePersonRequest object);
}
