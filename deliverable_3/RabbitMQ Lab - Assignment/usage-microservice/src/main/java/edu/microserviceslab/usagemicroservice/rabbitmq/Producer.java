package edu.microserviceslab.usagemicroservice.rabbitmq;

import edu.microserviceslab.usagemicroservice.Application;
import edu.microserviceslab.usagemicroservice.dto.PidRequest;
import edu.microserviceslab.usagemicroservice.dto.UsageStatisticRequest;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;

@Component
public class Producer implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;

    public Producer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending usage statistic request...");
        UsageStatisticRequest usageStatisticRequest = new UsageStatisticRequest();
        List<PidRequest> list = new LinkedList<>();
        PidRequest pidRequest = new PidRequest();
        pidRequest.setPid(5L);
        pidRequest.setData(135L);
        list.add(pidRequest);
        usageStatisticRequest.setVehicleId(1L);
        usageStatisticRequest.setData(list);
        while(true) {
            //You can comment out this line to see how the queue works while new requests aren't coming in.
            rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", usageStatisticRequest);
        }
    }
}