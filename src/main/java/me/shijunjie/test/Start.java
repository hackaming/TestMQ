package me.shijunjie.test;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.shijunjie.producer.MessageProducer;



public class Start {
    private static ApplicationContext context = null;  
    
	public static void main(String argv[]) throws IOException, InterruptedException{
		System.out.println("start");
		context = new ClassPathXmlApplicationContext("application.xml");  
        MessageProducer messageProducer = (MessageProducer) context.getBean("messageProducer");  
        for (int i=0;i<10;i++){
        	messageProducer.sendMessage("Hello, I am amq sender num :"+i);	
        	Thread.sleep(100);
        }
          
	}
}
