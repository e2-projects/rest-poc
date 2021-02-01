package lt.edas.demo.poc.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

    private String name;
    private String surname;
    private String address;
    private List<ContactDto> contacts;
}
