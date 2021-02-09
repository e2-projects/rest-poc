package lt.edas.demo.poc.rest.dto.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;

@Data
@SuperBuilder
@NoArgsConstructor
class PersonRequest {

    private String address;
    private String phone;
    @Email
    private String email;

}
