package lt.edas.demo.poc.services.mapper

import lt.edas.demo.poc.TestConstants
import lt.edas.demo.poc.TestObjects
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest
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

}
