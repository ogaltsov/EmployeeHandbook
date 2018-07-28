import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class);
    }

    //1) нужно ли везде открывать транзакцию или можно обойтись только сессией
    // (реализовать нормальную транзакционность)
    //2) нужно ли нам делать интерфейс от каждого дао, а только потом реализацию(полиморфизм)
}
