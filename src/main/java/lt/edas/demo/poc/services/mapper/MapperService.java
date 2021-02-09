package lt.edas.demo.poc.services.mapper;

import lt.edas.demo.poc.repositories.domain.Contact;
import lt.edas.demo.poc.repositories.domain.Person;
import lt.edas.demo.poc.rest.dto.PersonDto;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;

import java.util.List;

public interface MapperService {

    Person convertToPerson(CreatePersonRequest request);
    Person convertToPerson(UpdatePersonRequest request);
    Contact convertToContact(String phone, String email);
    PersonDto convertToDto(Person person);
    Iterable<PersonDto> convertToDtoList(List<Person> persons);

}
