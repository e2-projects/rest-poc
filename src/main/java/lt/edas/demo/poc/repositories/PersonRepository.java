package lt.edas.demo.poc.repositories;

import lt.edas.demo.poc.repositories.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<List<Person>> getAllByNameContainsOrSurnameContains(String name, String surname);
}
