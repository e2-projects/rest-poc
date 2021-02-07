package lt.edas.demo.poc.repositories.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "contact")
public class Contact {

    @Id
    @SequenceGenerator(name = "seq_contact_id", sequenceName = "seq_contact_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_contact_id")
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column
    private String phone;

    @Column(nullable = false)
    private String email;

    @OneToOne(mappedBy = "contact")
    private Person person;

}
