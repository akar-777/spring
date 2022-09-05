package ir.mahdi.training.spring.scope;

import ir.mahdi.training.spring.scope.conf.AppConfig;
import ir.mahdi.training.spring.scope.service.MessageService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService messageService = (MessageService)context.getBean("phoneMessage");
        messageService.setMessage("Phone message is sent successfully!");
        System.out.println(messageService.getMessage());

        MessageService msgService = (MessageService)context.getBean("phoneMessage");
        System.out.println(msgService.getMessage());

        context.close();
    }
}
