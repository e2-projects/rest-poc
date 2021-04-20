package lt.edas.demo.poc.services.person

import lt.edas.demo.poc.TestObjects
import lt.edas.demo.poc.TestConstants
import lt.edas.demo.poc.repositories.PersonRepository
import lt.edas.demo.poc.repositories.domain.Person
import lt.edas.demo.poc.services.mapper.MapperService
import spock.lang.Subject
import spock.lang.Specification

class PersonServiceImplTest extends Specification {

    @Subject
    private PersonService service
    private PersonRepository personRepository = Mock()
    private MapperService mapperService = Mock()

    def setup() {
        service = new PersonServiceImpl(personRepository, mapperService)
    }

    def "Should create person when request is correct"() {
        given: "create person request"
            def request = TestObjects.getCreatePersonRequest()
            def entity = TestObjects.getPersonEntity()
        when: "creating person"
            def id = service.createPerson(request)
        then: "save person in database once"
            1 * mapperService.convertToPerson(request) >> entity
            1 * personRepository.save(_ as Person) >> entity
        and: "id matches with "
            id == TestConstants.PERSON_ID_1
    }

    def "Should not create person when request is null"() {
        given: "create person request"
            def request = null
        when: "creating person"
            service.createPerson(request)
        then: "mapping request to entity"
            1 * mapperService.convertToPerson(request) >> null
        and: "save to database skipped"
            0 * personRepository.save(_ as Person)
    }

    def "Should search for person"() {
        given: "search parameter"
            def searchParam = "i"
        when: "searching person"
            def result = service.getPersons(searchParam)
        then: "get list of database objects"
            1 * personRepository.getAllByNameContainsOrSurnameContains(searchParam, searchParam) >>
                    Optional.of(TestObjects.getPersonEntityListForSearch())
        and: "map it to data transfer objects list"
            1 * mapperService.convertToDtoList(_) >> TestObjects.getPersonDtoListForSearch()
        and: "result matches expectations"
            result.getPersons().size() == 2
    }

    def "Should get empty list when searching"() {
        given: "search parameter"
            def searchParam = "abc"
        when: "searching person"
            def result = service.getPersons(searchParam)
        then: "get null from database"
            1 * personRepository.getAllByNameContainsOrSurnameContains(searchParam, searchParam) >>
                    Optional.of(Collections.emptyList())
        and: "map it to data transfer objects list"
            1 * mapperService.convertToDtoList(_) >> Collections.emptyList()
        and: "result matches expectations"
            result.getPersons().size() == 0
    }

    def "Should update person"() {
        given: "update request and entity and updated entity"
            def request = TestObjects.getUpdatePersonRequest()
            def entity = TestObjects.getPersonEntity()
            def updatedEntity = TestObjects.getUpdatedPersonEntity()
        when: "updating person"
            service.updatePerson(request)
        then: "fetch person entity by id"
            1 * personRepository.getOne(TestConstants.PERSON_ID_1) >> entity
        and: "map update request with person entity"
            1 * mapperService.convertToPerson(entity, request) >> updatedEntity
        and: "updated entity saved to database"
            1 * personRepository.save(updatedEntity)
    }

}
