package hello.itemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItemServiceApplication { //implements WebMvcConfigurer

    public static void main(String[] args) {
        SpringApplication.run(ItemServiceApplication.class, args);
    }

    /**
     * @InitBinder: 해당 컨트롤러만 가능
     * implements WebMvcConfigurer: 글로벌 설정
     */
/*    @Override
    public Validator getValidator() {
        return new ItemValidator();
    }*/
}
