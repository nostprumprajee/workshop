package toystore.repository;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataJpaTest
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldSaveAndGetData() throws Exception {
        // Arrange
        Person taey = new Person("nitipat", "lowichakornthikun");
        personRepository.save(taey);

        // Action
        Optional<Person> person = personRepository.findByFirstName("nitipat");

        // Assert
        assertEquals("nitipat", person.get().getFirstName());
        assertEquals("lowichakornthikun", person.get().getLastName());

    }

    @After
    public void clearData() {
        personRepository.deleteAll();
    }

}