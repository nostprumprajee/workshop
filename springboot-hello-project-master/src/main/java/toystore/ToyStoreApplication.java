package toystore;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import toystore.repository.Person;
import toystore.repository.PersonRepository;

@SpringBootApplication
public class ToyStoreApplication {
    @Autowired
    private PersonRepository personRepository;

    public static void main(String... args) {
        SpringApplication.run(ToyStoreApplication.class,args);
    }

    @Bean
    InitializingBean sendDatabase() {
        return () -> {
            personRepository.deleteAll();
            personRepository.save(new Person("John", "Snow"));
            personRepository.save(new Person("Nitipat", "Lowic"));
        };
    }
}
