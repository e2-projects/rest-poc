package lt.edas.demo.poc.rest.dto.request;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UpdatePersonRequest extends PersonRequest {

    private Long id;
    private String name;
    private String surname;

}
