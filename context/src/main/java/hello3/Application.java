package hello3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

import hello.MessagePrinter;
import hello.MessageService;

@Configuration
@ComponentScan("hello")
public class Application {

    @Bean
    MessageService mockMessageService() {
        return new MessageService() {
            public String getMessage() {
              return "Hello World!";
            }
        };
    }

  public static void main(String[] args) {
      ApplicationContext context = 
          new AnnotationConfigApplicationContext(Application.class);
      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
  }
}
