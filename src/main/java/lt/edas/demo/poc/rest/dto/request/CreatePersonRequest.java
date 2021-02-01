package lt.edas.demo.poc.rest.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePersonRequest {

    @NonNull
    @Size(min = 2)
    private String name;

    @NonNull
    @Size(min = 2)
    private String surname;

    private String address;

    private String phone;

    @Email
    private String email;
}
