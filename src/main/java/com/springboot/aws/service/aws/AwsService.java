package com.springboot.aws.service.aws;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.springboot.aws.domain.aws.MessageAwsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class AwsService {

    private AmazonSNS amazonSNS;

    private Topic roomTopic;

    public AwsService(@Qualifier("roomEventTopic") Topic roomTopic, AmazonSNS amazonSNS) {
        this.roomTopic = roomTopic;
        this.amazonSNS = amazonSNS;
    }

    public void publishMessage(MessageAwsDTO messageAwsDTO){
        this.amazonSNS.publish(roomTopic.getTopicArn(), messageAwsDTO.message());

    }
}
