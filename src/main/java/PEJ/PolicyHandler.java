package PEJ;

import PEJ.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    OrderRepository orderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverShipped_ChangeStatus(@Payload Shipped shipped){


        if(shipped.isMe()){

            Long ordId = shipped.getOrderId();

            if(null != ordId){
                Optional<Order> orderOptional = orderRepository.findByOrderId(Long.valueOf("" + shipped.getOrderId()));
                Order order = orderOptional.get();

                order.setOrderStatus("SHIPPED");
                orderRepository.save(order);
                System.out.println("##### listener Order : " + shipped.toJson());
            }

        }

    }


}
