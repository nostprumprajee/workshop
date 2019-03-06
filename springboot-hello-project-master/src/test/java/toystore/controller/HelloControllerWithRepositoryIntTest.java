package toystore.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import toystore.repository.Person;
import toystore.repository.PersonRepository;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloControllerWithRepository.class)
public class HelloControllerWithRepositoryIntTest {
    @MockBean
    private PersonRepository personRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldBeReturnHelloNitipat() throws Exception {
        Person nitipat = new Person("Nitipat", "L");
        given(personRepository.findByFirstName("Nitipat")).willReturn(Optional.of(nitipat));

        mockMvc.perform(get("/hello/data/Nitipat"))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.message").value("Hello Nitipat"));

    }

}