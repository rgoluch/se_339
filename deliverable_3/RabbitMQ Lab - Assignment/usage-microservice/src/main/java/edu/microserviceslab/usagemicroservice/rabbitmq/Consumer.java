package edu.microserviceslab.usagemicroservice.rabbitmq;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.microserviceslab.usagemicroservice.dto.PidRequest;
import edu.microserviceslab.usagemicroservice.dto.UsageStatisticRequest;
import edu.microserviceslab.usagemicroservice.entity.UsageStatistic;
import edu.microserviceslab.usagemicroservice.repo.UsageStatisticRepo;
import edu.microserviceslab.usagemicroservice.service.interfaces.UsageService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

//Make your modifications here. You may need to add more methods or a constructor.
public class Consumer implements MessageListener {

    private UsageService u;
    private UsageStatisticRepo r;

    Consumer(){
        super();
    }

    public Consumer(UsageService u){
        this.u = u;
    }

    @Override
    public void onMessage(Message message) {

        byte[] j = message.getBody();
        ObjectMapper mapper = new ObjectMapper();
        UsageStatisticRequest s = null;
        try {
            s = mapper.readValue(j, UsageStatisticRequest.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<PidRequest> pid = s.getPids();

        for (PidRequest p : pid){
            UsageStatistic temp = new UsageStatistic();
            temp.setVehicleId(s.getVehicleId());
            temp.setPid(p.getPid());
            temp.setData(p.getData());

            r.save(temp);
        }
    }
}
