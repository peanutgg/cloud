package com.example.kafka.com.xxd.producer;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

public class MyProducer {
    public static void main(String[] args) throws InterruptedException {
        //1.创建Kafka生产者配置信息
        Properties properties = new Properties();
        properties.put("bootstrap.servers","192.168.31.29:9092");
        //应答级别
        properties.put("acks", "all");
        //重试次数
        properties.put("retries", 1);
        //批次大小消息达到16k写到RecordAccumulator中
        properties.put("batch.size", 16384);//16k//
        properties.put("linger.ms", 1);//等待时间超过1ms发送下一条消息
        //RecordAccumulator缓冲区大小
        properties.put("buffer.memory", 33554432);//32M 缓冲区大小
        properties.put("key.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");
        properties.put("value.serializer",
                "org.apache.kafka.common.serialization.StringSerializer");

        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

        for (int i = 0; i < 10; i++) {
            System.out.println("1");
            producer.send(new ProducerRecord<>("xxd04", "xxd04-03" + i),(recordMetadata, e) -> {
                if (e != null) {
                    e.printStackTrace();
                }else{
                    System.out.println(recordMetadata.topic());
                }

            });
        }
//        Thread.sleep(100);
        //关闭资源
        producer.close();

    }
}
