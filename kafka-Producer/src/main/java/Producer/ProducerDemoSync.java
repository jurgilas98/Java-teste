package Producer;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Map;

public class ProducerDemoSync {
    public static void main(String[] args) {


        String topicName = "jurgilastopic1";
        String key = "Key1";
        String value = "Value-";


        Properties props = new Properties();
        props.put("bootstrap.servers","52.224.181.51:9092");
        props.put("client.id","13.90.205.181:2181");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(props);

        for (int i = 0; i < 20; i++) {

            ProducerRecord<String, String> producerRecord = new ProducerRecord(topicName, key, value + i);

            kafkaProducer.send(producerRecord);


            List partitionInfoList = kafkaProducer.partitionsFor("jurgilastopic1");

            System.out.println(partitionInfoList);

            Map metrics = kafkaProducer.metrics();
            System.out.println(metrics);

        }
        kafkaProducer.close();


    }
}

