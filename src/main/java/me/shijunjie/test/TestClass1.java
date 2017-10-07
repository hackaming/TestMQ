package me.shijunjie.test;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.shijunjie.producer.MessageProducer;

public class TestClass1 {

     
  
    private static ApplicationContext context = null;  
  
    
    public void setUp() throws Exception {  
        context = new ClassPathXmlApplicationContext("application.xml");  
    }  
  

    public void should_send_a_amq_message() throws Exception {  
        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");  
        int a = 100;  
        while (a > 0) {  
            messageProducer.sendMessage("Hello, I am amq sender num :" + a--);  
            try {  
                //暂停一下，好让消息消费者去取消息打印出来  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
   
        }  
    }
    public static void main(String argv[]) throws Exception{
    	TestClass1 tt = new TestClass1();
    	tt.setUp();
    	tt.should_send_a_amq_message();
    }
}
