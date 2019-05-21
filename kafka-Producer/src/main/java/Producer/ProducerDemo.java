package Producer;

import java.util.Properties;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.List;
import java.util.Map;

public class ProducerDemo {

    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("bootstrap.servers","52.224.181.51:9092");
        props.put("client.id","13.90.205.181:2181");
        props.put("key.serializer","org.apache.kafka.common.serialization.ByteArraySerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.ByteArraySerializer");


        KafkaProducer kafkaProducer = new KafkaProducer(props);

        int i =0 ;

        kafkaProducer.send(new ProducerRecord("jurgilastopic1", (i + "").getBytes(), ("Registro"+i).getBytes()));



        List partitionInfoList = kafkaProducer.partitionsFor("jurgilastopic1");





        Map metrics = kafkaProducer.metrics();



        kafkaProducer.close();






    }



}