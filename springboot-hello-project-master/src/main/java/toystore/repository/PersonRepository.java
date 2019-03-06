package toystore.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<Person, String> {

    @Autowired
    public Optional<Person> findByFirstName(String name);
}
