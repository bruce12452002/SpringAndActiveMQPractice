package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class ProduceService {
    @Autowired
    private JmsTemplate jmsTemplate;

    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        ProduceService produce = app.getBean("produceService", ProduceService.class);
        produce.jmsTemplate.send(s -> s.createTextMessage("send message"));
        System.out.println("生產者已傳送出去!!");
    }
}
