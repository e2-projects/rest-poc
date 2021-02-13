package lt.edas.demo.poc.services.mapper

import lt.edas.demo.poc.TestConstants
import lt.edas.demo.poc.TestObjects
import lt.edas.demo.poc.repositories.domain.Person
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest
import org.slf4j.Logger
import spock.lang.Specification
import spock.lang.Subject

class MapperServiceImplTest extends Specification {

    @Subject
    private MapperService service;
    private Logger logger = Mock()

    def setup() {
        service = new MapperServiceImpl(logger)
    }

    def "Should convert CreatePersonRequest to Person entity"() {
        given: "person create request"
            def request = TestObjects.getCreatePersonRequest()
        when: "converting to Person entity"
            def person = service.convertToPerson(request)
        then: "person request should be correct"
            person.getName() == request.getName()
            person.getSurname() == request.getSurname()
            person.getAddress() == request.getAddress()
            person.getContact().getPhone() == request.getPhone()
            person.getContact().getEmail() == request.getEmail()
    }

    def "Should return null when request is null"() {
        given: "null create person request"
            def request = null
        when: "converting to Person entity"
            def person = service.convertToPerson(request)
        then: "logger logs error"
            1 * logger.error("{} object is null", CreatePersonRequest.getName())
        and: "person entity is null"
            person == null
    }

    def "Should convert UpdatePersonRequest to Person entity"() {
        given: "update request and fetched Person entity"
            def request = TestObjects.getUpdatePersonRequest()
            def fetched = TestObjects.getPersonEntity()
        and: "person is first"
            fetched.getName() == TestConstants.PERSON_NAME_1
            fetched.getAddress() == TestConstants.PERSON_ADDRESS_1
            fetched.getContact().getEmail() == TestConstants.PERSON_EMAIL_1
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "person entity is updated"
            person.getId() == request.getId()
            person.getName() == request.getName()
            person.getName() == TestConstants.PERSON_NAME_2
            person.getAddress() == request.getAddress()
            person.getAddress() == TestConstants.PERSON_ADDRESS_2
            person.getContact().getEmail() == request.getEmail()
            person.getContact().getEmail() == TestConstants.PERSON_EMAIL_2
    }
    
    def "Should convert UpdatePersonRequest when only name set"() {
        given: "update request and fetched Person entity"
            def request = TestObjects.getNameUpdateRequest()
            def fetched = TestObjects.getPersonEntity()
        and: "current and new name is different"
            fetched.getName() == TestConstants.PERSON_NAME_1
            request.getName() == TestConstants.PERSON_NAME_2
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "only person name is updated"
            person.getName() == TestConstants.PERSON_NAME_2
            person.getSurname() == TestConstants.PERSON_SURNAME_1
            person.getAddress() == TestConstants.PERSON_ADDRESS_1
            person.getContact().getEmail() == TestConstants.PERSON_EMAIL_1
            person.getContact().getPhone() == TestConstants.PERSON_PHONE_1
    }

    def "Should convert UpdatePersonRequest when only surname set"() {
        given: "update request and fetched Person entity"
            def request = TestObjects.getSurnameUpdateRequest()
            def fetched = TestObjects.getPersonEntity()
        and: "current and new surname is different"
            fetched.getSurname() == TestConstants.PERSON_SURNAME_1
            request.getSurname() == TestConstants.PERSON_SURNAME_2
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "only person surname is updated"
            person.getName() == TestConstants.PERSON_NAME_1
            person.getSurname() == TestConstants.PERSON_SURNAME_2
            person.getAddress() == TestConstants.PERSON_ADDRESS_1
            person.getContact().getEmail() == TestConstants.PERSON_EMAIL_1
            person.getContact().getPhone() == TestConstants.PERSON_PHONE_1
    }

    def "Should convert UpdatePersonRequest when only address set"() {
        given: "update request and fetched Person entity"
            def request = TestObjects.getAddressUpdateRequest()
            def fetched = TestObjects.getPersonEntity()
        and: "current and new address is different"
            fetched.getAddress() == TestConstants.PERSON_ADDRESS_1
            request.getAddress() == TestConstants.PERSON_ADDRESS_2
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "only person surname is updated"
            person.getName() == TestConstants.PERSON_NAME_1
            person.getSurname() == TestConstants.PERSON_SURNAME_1
            person.getAddress() == TestConstants.PERSON_ADDRESS_2
            person.getContact().getEmail() == TestConstants.PERSON_EMAIL_1
            person.getContact().getPhone() == TestConstants.PERSON_PHONE_1
    }

    def "Should convert UpdatePersonRequest when only email and phone set"() {
        given: "update request and fetched Person entity"
            def request = TestObjects.getContactsUpdateRequest()
            def fetched = TestObjects.getPersonEntity()
        and: "current and new phone and email is different"
            fetched.getContact().getPhone() == TestConstants.PERSON_PHONE_1
            fetched.getContact().getEmail() == TestConstants.PERSON_EMAIL_1
            request.getPhone() == TestConstants.PERSON_PHONE_2
            request.getEmail() == TestConstants.PERSON_EMAIL_2
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "only person surname is updated"
            person.getName() == TestConstants.PERSON_NAME_1
            person.getSurname() == TestConstants.PERSON_SURNAME_1
            person.getAddress() == TestConstants.PERSON_ADDRESS_1
            person.getContact().getEmail() == TestConstants.PERSON_EMAIL_2
            person.getContact().getPhone() == TestConstants.PERSON_PHONE_2
    }

    def "Should return same entity when UpdatePersonRequest in empty"() {
        given: "update request and fetched Person entity"
            def request = UpdatePersonRequest.builder().build()
            def fetched = TestObjects.getPersonEntity()
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "entity has same values as before converting"
            person.getName() == fetched.getName()
            person.getSurname() == fetched.getSurname()
            person.getAddress() == fetched.getAddress()
            person.getContact().getEmail() == fetched.getContact().getEmail()
            person.getContact().getPhone() == fetched.getContact().getPhone()
    }

    def "Should log error and return same entity when UpdatePersonRequest is null"() {
        given: "update request and fetched Person entity"
            def request = null
            def fetched = TestObjects.getPersonEntity()
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "error is logged"
            1 * logger.error("{} object is null", UpdatePersonRequest.getName())
        and: "entity has same values as before converting"
            person.getName() == fetched.getName()
            person.getSurname() == fetched.getSurname()
            person.getAddress() == fetched.getAddress()
            person.getContact().getEmail() == fetched.getContact().getEmail()
            person.getContact().getPhone() == fetched.getContact().getPhone()
    }

    def "Should log error and return same entity when entity is null"() {
        given: "update request and fetched Person entity"
            def request = TestObjects.getUpdatePersonRequest()
            def fetched = null
        when: "converting to Person entity"
            def person = service.convertToPerson(fetched, request)
        then: "error is logged"
            1 * logger.error("{} object is null", Person.getName())
        and: "entity is null"
            person == fetched
    }

}
