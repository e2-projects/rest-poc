package lt.edas.demo.poc.rest.dto.request;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Size;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CreatePersonRequest extends PersonRequest {

    @NonNull
    @Size(min = 2)
    private String name;

    @NonNull
    @Size(min = 2)
    private String surname;

}
