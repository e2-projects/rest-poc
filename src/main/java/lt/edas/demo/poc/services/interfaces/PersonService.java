package lt.edas.demo.poc.services.interfaces;

import lt.edas.demo.poc.rest.dto.PersonDto;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;

import java.util.List;

public interface PersonService {

    void createPerson(CreatePersonRequest request);

    List<PersonDto> getPersons();

    void updatePerson(PersonDto object);
}
