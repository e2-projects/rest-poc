package lt.edas.demo.poc;

import lt.edas.demo.poc.repositories.domain.Contact;
import lt.edas.demo.poc.repositories.domain.Person;
import lt.edas.demo.poc.rest.dto.PersonDto;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;

import java.util.Arrays;
import java.util.List;

import static lt.edas.demo.poc.TestConstants.*;

public class TestObjects {

    public static Person getPersonEntity() {
        return buildPersonEntity(
                PERSON_ID_1, PERSON_NAME_1, PERSON_SURNAME_1,
                PERSON_ADDRESS_1, PERSON_PHONE_1, PERSON_EMAIL_1
        );
    }

    public static List<Person> getPersonEntityList() {
        return Arrays.asList(
                buildPersonEntity(
                        PERSON_ID_1, PERSON_NAME_1, PERSON_SURNAME_1,
                        PERSON_ADDRESS_1, PERSON_PHONE_1, PERSON_EMAIL_1
                ),
                buildPersonEntity(
                        PERSON_ID_2, PERSON_NAME_2, PERSON_SURNAME_2,
                        PERSON_ADDRESS_2, PERSON_PHONE_2, PERSON_EMAIL_2
                ),
                buildPersonEntity(
                        PERSON_ID_3, PERSON_NAME_3, PERSON_SURNAME_3,
                        PERSON_ADDRESS_3, PERSON_PHONE_3, PERSON_EMAIL_3
                )
        );
    }

    public static List<Person> getPersonEntityListForSearch() {
        return Arrays.asList(
                buildPersonEntity(
                        PERSON_ID_2, PERSON_NAME_2, PERSON_SURNAME_2,
                        PERSON_ADDRESS_2, PERSON_PHONE_2, PERSON_EMAIL_2
                ),
                buildPersonEntity(
                        PERSON_ID_3, PERSON_NAME_3, PERSON_SURNAME_3,
                        PERSON_ADDRESS_3, PERSON_PHONE_3, PERSON_EMAIL_3
                )
        );
    }

    public static List<PersonDto> getPersonDtoListForSearch() {
        return Arrays.asList(
                buildPersonDto(PERSON_NAME_2, PERSON_SURNAME_2),
                buildPersonDto(PERSON_NAME_3, PERSON_SURNAME_3)
        );
    }

    public static CreatePersonRequest getCreatePersonRequest() {
        return CreatePersonRequest.builder()
                .name(PERSON_NAME_1)
                .surname(PERSON_SURNAME_1)
                .address(PERSON_ADDRESS_1)
                .phone(PERSON_PHONE_1)
                .email(PERSON_EMAIL_1)
                .build();
    }

    public static UpdatePersonRequest getNameUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .name(PERSON_NAME_2)
                .build();
    }

    public static UpdatePersonRequest getSurnameUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .surname(PERSON_SURNAME_2)
                .build();
    }

    public static UpdatePersonRequest getAddressUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .address(PERSON_ADDRESS_2)
                .build();
    }

    public static UpdatePersonRequest getContactsUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .phone(PERSON_PHONE_2)
                .email(PERSON_EMAIL_2)
                .build();
    }

    public static UpdatePersonRequest getUpdatePersonRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .name(PERSON_NAME_2)
                .address(PERSON_ADDRESS_2)
                .email(PERSON_EMAIL_2)
                .build();
    }

    private static Person buildPersonEntity(Long id, String name, String surname,
                                            String address, String phone, String email) {
        return Person.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .address(address)
                .build()
                .addContact(buildContactEntity(id, phone, email));
    }

    private static Contact buildContactEntity(Long id, String phone, String email) {
        return Contact.builder()
                .id(id)
                .phone(phone)
                .email(email)
                .build();
    }

    private static PersonDto buildPersonDto(String name, String surname
                                            /*String address, String phone, String email*/) {
        return PersonDto.builder()
                .name(name)
                .surname(surname)
                /*.address(address)
                .contacts(Collections.singletonList(
                        ContactDto.builder()
                                .phone(phone)
                                .email(email)
                                .build()))*/
                .build();
    }

}
