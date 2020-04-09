package edu.microserviceslab.usagemicroservice.rabbitmq;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.microserviceslab.usagemicroservice.dto.PidRequest;
import edu.microserviceslab.usagemicroservice.dto.UsageStatisticRequest;
import edu.microserviceslab.usagemicroservice.entity.UsageStatistic;
import edu.microserviceslab.usagemicroservice.service.interfaces.UsageService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

//Make your modifications here. You may need to add more methods or a constructor.
public class Consumer implements MessageListener {
    @Override
    public void onMessage(Message message) {

    }
}
