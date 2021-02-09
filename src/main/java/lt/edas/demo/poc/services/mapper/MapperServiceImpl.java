package lt.edas.demo.poc.services.mapper;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.exceptions.MapperException;
import lt.edas.demo.poc.repositories.domain.Contact;
import lt.edas.demo.poc.repositories.domain.Person;
import lt.edas.demo.poc.rest.dto.PersonDto;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
class MapperServiceImpl implements MapperService {

    private final Logger logger;

    @Override
    public Person convertToPerson(CreatePersonRequest request) {
        try {
            checkObject(request, CreatePersonRequest.class);
            return Person.builder()
                    .name(request.getName())
                    .surname(request.getSurname())
                    .address(request.getAddress())
                    .build()
                    .addContact(
                            convertToContact(
                                    request.getPhone(),
                                    request.getEmail()
                            )
                    );
        } catch (MapperException e) {
            return null;
        }
    }

    @Override
    public Person convertToPerson(UpdatePersonRequest request) {
        try {
            checkObject(request, UpdatePersonRequest.class);
            return null;
        } catch (MapperException e) {
            return null;
        }
    }

    @Override
    public Contact convertToContact(String phone, String email) {
        return Contact.builder()
                .phone(phone)
                .email(email)
                .build();
    }

    @Override
    public PersonDto convertToDto(Person person) {
        try {
            checkObject(person, Person.class);
            return PersonDto.builder()
                    .name(person.getName())
                    .surname(person.getSurname())
                    .build();
        } catch (MapperException e) {
            return null;
        }
    }

    @Override
    public Iterable<PersonDto> convertToDtoList(List<Person> persons) {
        try {
            checkObjectList(persons, Person.class);
            return persons.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        } catch (MapperException e) {
            return Collections.emptyList();
        }
    }

    private void checkObject(Object object, Class objectClass) {
        if (object == null) {
            logger.error("{} object is null", objectClass.getName());
            throw new MapperException();
        }
    }

    private void checkObjectList(List list, Class listItemClass) {
        if (list == null || list.isEmpty()) {
            logger.error("{} list is null or empty.", listItemClass.getName());
            throw new MapperException();
        }
    }
}
