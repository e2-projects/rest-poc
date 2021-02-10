package lt.edas.demo.poc.rest.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;

@Data
@ToString
@SuperBuilder
@NoArgsConstructor
class PersonRequest {

    private String address;
    private String phone;
    @Email
    private String email;

}
