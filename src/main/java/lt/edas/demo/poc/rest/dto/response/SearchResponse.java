package lt.edas.demo.poc.rest.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.edas.demo.poc.rest.dto.PersonDto;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchResponse {

    private Iterable<PersonDto> persons;
}
