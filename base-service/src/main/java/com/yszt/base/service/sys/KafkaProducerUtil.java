package com.yszt.base.service.sys;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;

/**
 * @Date May 22, 2015
 *
 * @Author 
 *
 * @Note 
 */
public class KafkaProducerUtil  {

	Producer<String, String> producer;

    private Properties props = new Properties();
    private final int SLEEP = 1000 * 3;

    public KafkaProducerUtil() {
    	
    	 Properties props = new Properties();
    	 props.put("bootstrap.servers", "192.168.1.55:9092");
    	 props.put("acks", "all");
    	 props.put("retries", 0);
    	 props.put("batch.size", 16384);
    	 props.put("linger.ms", 1);
    	 props.put("buffer.memory", 33554432);
    	 props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	 props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    	
        
         producer = new KafkaProducer<>(props);
        
    }

   public void sendMsg(){
	   producer.send(new ProducerRecord<String, String>("test", Integer.toString(1), "hello kafka 123"));

	   producer.close();
	   
   }
   
   public static void main(String[] args) {
	   new KafkaProducerUtil().sendMsg();
   }

}
