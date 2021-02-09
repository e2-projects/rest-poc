package lt.edas.demo.poc.services.person;

import lombok.RequiredArgsConstructor;
import lt.edas.demo.poc.repositories.PersonRepository;
import lt.edas.demo.poc.rest.dto.request.CreatePersonRequest;
import lt.edas.demo.poc.rest.dto.request.UpdatePersonRequest;
import lt.edas.demo.poc.rest.dto.response.SearchResponse;
import lt.edas.demo.poc.services.mapper.MapperService;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
class PersonServiceImpl implements PersonService {

    private final PersonRepository repository;
    private final MapperService mapper;

    @Override
    public Long createPerson(CreatePersonRequest request) {
        var entity = mapper.convertToPerson(request);
        return entity != null ?
                repository.save(entity).getId() :
                0;
    }

    @Override
    public SearchResponse getPersons(String searchParam) {
        return new SearchResponse(mapper.convertToDtoList(
                repository.getAllByNameContainsOrSurnameContains(searchParam, searchParam)
                        .orElse(Collections.emptyList())
        ));
    }

    @Override
    public void updatePerson(UpdatePersonRequest request) {

    }

}
