package toystore.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import toystore.domain.Hello;
import toystore.repository.Person;
import toystore.repository.PersonRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.MockitoAnnotations.initMocks;

public class HelloControllerWithRepositoryTest {

    @Mock
    private PersonRepository personRepository;

    private HelloControllerWithRepository controller;

    @Before
    public void init() {
        initMocks(this);
        controller = new HelloControllerWithRepository(personRepository);
    }


    @Test
    public void shouldBeReturnHelloNitipat() {
        Person nitipat = new Person("Nitipat", "L");
        given(personRepository.findByFirstName("Nitipat")).willReturn(Optional.of(nitipat));

        Hello hello = controller.sayHi("Nitipat");

        assertEquals("Hello Nitipat", hello.getMessage());
    }
}