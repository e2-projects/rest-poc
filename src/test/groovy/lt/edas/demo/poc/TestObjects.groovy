package lt.edas.demo.poc

import lt.edas.demo.poc.repositories.domain.Contact
import lt.edas.demo.poc.repositories.domain.Person
import lt.edas.demo.poc.rest.dto.PersonDto
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest

import static lt.edas.demo.poc.TestConstants.*

class TestObjects {

    static Person getPersonEntity() {
        buildPersonEntity(
                PERSON_ID_1, PERSON_NAME_1, PERSON_SURNAME_1,
                PERSON_ADDRESS_1, PERSON_PHONE_1, PERSON_EMAIL_1
        )
    }

    static Person getUpdatedPersonEntity() {
        buildPersonEntity(
                PERSON_ID_1, PERSON_NAME_2, PERSON_SURNAME_1,
                PERSON_ADDRESS_2, PERSON_PHONE_1, PERSON_EMAIL_2
        )
    }

    static List<Person> getPersonEntityList() {
        Arrays.asList(
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
        )
    }

    static List<Person> getPersonEntityListForSearch() {
        Arrays.asList(
                buildPersonEntity(
                        PERSON_ID_2, PERSON_NAME_2, PERSON_SURNAME_2,
                        PERSON_ADDRESS_2, PERSON_PHONE_2, PERSON_EMAIL_2
                ),
                buildPersonEntity(
                        PERSON_ID_3, PERSON_NAME_3, PERSON_SURNAME_3,
                        PERSON_ADDRESS_3, PERSON_PHONE_3, PERSON_EMAIL_3
                )
        )
    }

    static List<PersonDto> getPersonDtoListForSearch() {
        return Arrays.asList(
                buildPersonDto(PERSON_NAME_2, PERSON_SURNAME_2),
                buildPersonDto(PERSON_NAME_3, PERSON_SURNAME_3)
        )
    }

    static CreatePersonRequest getCreatePersonRequest() {
        return CreatePersonRequest.builder()
                .name(PERSON_NAME_1)
                .surname(PERSON_SURNAME_1)
                .address(PERSON_ADDRESS_1)
                .phone(PERSON_PHONE_1)
                .email(PERSON_EMAIL_1)
                .build()
    }

    static UpdatePersonRequest getNameUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .name(PERSON_NAME_2)
                .build()
    }

    static UpdatePersonRequest getSurnameUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .surname(PERSON_SURNAME_2)
                .build()
    }

    static UpdatePersonRequest getAddressUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .address(PERSON_ADDRESS_2)
                .build()
    }

    static UpdatePersonRequest getContactsUpdateRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .phone(PERSON_PHONE_2)
                .email(PERSON_EMAIL_2)
                .build()
    }

    static UpdatePersonRequest getUpdatePersonRequest() {
        return UpdatePersonRequest.builder()
                .id(PERSON_ID_1)
                .name(PERSON_NAME_2)
                .address(PERSON_ADDRESS_2)
                .email(PERSON_EMAIL_2)
                .build()
    }

    private static Person buildPersonEntity(Long id, String name, String surname,
                                            String address, String phone, String email) {
        Person.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .address(address)
                .build()
                .addContact(buildContactEntity(id, phone, email));
    }

    private static Contact buildContactEntity(Long id, String phone, String email) {
        Contact.builder()
                .id(id)
                .phone(phone)
                .email(email)
                .build();
    }

    private static PersonDto buildPersonDto(String name, String surname) {
        PersonDto.builder()
                .name(name)
                .surname(surname)
                .build();
    }
}
