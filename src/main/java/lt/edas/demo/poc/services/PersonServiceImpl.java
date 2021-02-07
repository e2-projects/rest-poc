package lt.edas.demo.poc.services;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.repositories.PersonRepository;
import lt.edas.demo.poc.repositories.domain.Contact;
import lt.edas.demo.poc.repositories.domain.Person;
import lt.edas.demo.poc.rest.dto.PersonDto;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.services.interfaces.PersonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;

    @Override
    public void createPerson(CreatePersonRequest request) {
        repository.save(getPerson(request));
    }

    @Override
    public List<PersonDto> getPersons() {
        return null;
    }

    @Override
    public void updatePerson(PersonDto object) {

    }

    private Person getPerson(CreatePersonRequest request) {
        return Person.builder()
                .name(request.getName())
                .surname(request.getSurname())
                .address(request.getAddress())
                .build()
                .addContact(getContact(request.getPhone(), request.getEmail()));
    }

    private Contact getContact(String phone, String email) {
        return Contact.builder()
                .phone(phone)
                .email(email)
                .build();
    }
}
