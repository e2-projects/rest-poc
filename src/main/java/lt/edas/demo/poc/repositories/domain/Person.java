package lt.edas.demo.poc.repositories.domain;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "person")
public class Person {

    @Id
    @SequenceGenerator(name = "seq_person_id", sequenceName = "seq_person_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_person_id")
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column
    private String address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "id")
    private Contact contact;

    public Person addContact(Contact contact) {
        contact.setPerson(this);
        this.contact = contact;
        return this;
    }
}
