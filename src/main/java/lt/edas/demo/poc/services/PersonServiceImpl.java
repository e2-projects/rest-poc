package lt.edas.demo.poc.services;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.repositories.PersonRepository;
import lt.edas.demo.poc.repositories.domain.Contact;
import lt.edas.demo.poc.repositories.domain.Person;
import lt.edas.demo.poc.rest.dto.PersonDto;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import lt.edas.demo.poc.services.interfaces.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public Long createPerson(CreatePersonRequest request) {
        return repository.save(convertToPerson(request)).getId();
    }

    @Override
    public SearchResponse getPersons(String searchParam) {
        return new SearchResponse(convertToDtoList(
                repository.getAllByNameContainsOrSurnameContains(searchParam, searchParam)
                        .orElse(new ArrayList<>())
        ));
    }

    @Override
    public void updatePerson(UpdatePersonRequest object) {

    }

    private Person convertToPerson(CreatePersonRequest request) {
        return Person.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .build()
                .addContact(convertToContact(request.getPhone(), request.getEmail()));
    }

    private Contact convertToContact(String phone, String email) {
        return Contact.builder()
                .phone(phone)
                .email(email)
                .build();
    }

    private Iterable<PersonDto> convertToDtoList(List<Person> persons) {
        return persons.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    private PersonDto convertToDto(Person person) {
        return PersonDto.builder()
                .name(person.getName())
                .surname(person.getSurname())
                .build();
    }

}
