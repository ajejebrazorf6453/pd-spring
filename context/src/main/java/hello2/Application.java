package hello2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import hello.MessagePrinter;
import hello.MessageService;

public class Application {

  public static void main(String[] args) {
      ApplicationContext context = 
          new ClassPathXmlApplicationContext("hello2/test_context.xml");

      MessagePrinter printer = context.getBean(MessagePrinter.class);
      printer.printMessage();
      ConfigurableMessageService x = 
    		  context.getBean("confMessageService",ConfigurableMessageService.class);
      
      x.setMessage("changed by the code");
      printer.printMessage();
  }
}
