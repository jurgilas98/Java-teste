package Producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;



public class ProducerDemoKeyed {
    public static void main(String[] args) {

        String topicName = "jurgilastopic1";
        String value = "Value-";


        Properties props = new Properties();
        props.put("bootstrap.servers","13.90.154.158:9092");
        props.put("client.id","52.168.74.89:2181");
        props.put("key.serializer","org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer","org.apache.kafka.common.serialization.StringSerializer");



        KafkaProducer <String, String> kafkaProducer = new KafkaProducer(props);
        for (int i=0 ; i<20 ; i++) {
            ProducerRecord<String, String> producerRecord = new ProducerRecord(topicName,  value + i);

            kafkaProducer.send(producerRecord, new ProducerCallback());
            System.out.println("Chamou");
        }
        kafkaProducer.close();




    }

    static class ProducerCallback implements Callback{

        @Override
        public void onCompletion(RecordMetadata recordMetadata, Exception e) {
            if (e != null) {
                System.out.println("Erro:"+e);
            } else {
                System.out.println("Gravado no offset: "+recordMetadata.offset());
                System.out.println("Gravado na partition "+ recordMetadata.partition());

            }

        }
    }

}
