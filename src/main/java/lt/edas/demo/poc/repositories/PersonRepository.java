package lt.edas.demo.poc.repositories;

import lt.edas.demo.poc.repositories.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
