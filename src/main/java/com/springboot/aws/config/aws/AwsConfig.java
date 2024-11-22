package com.springboot.aws.config.aws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.Topic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AwsConfig {

    @Value("${aws.region}")
    private String region;
    @Value("${aws.accessKeyId}")
    private String accessKeyId;
    @Value("${aws.secretKey}")
    private String secretKey;
    @Value("${aws.sns.topic.room.arn}")
    private String roomArn;

    @Bean
    public AmazonSNS amazonSNSBuilder(){
        BasicAWSCredentials secret = new BasicAWSCredentials(accessKeyId,secretKey);
        return AmazonSNSClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(secret)).withRegion(region).build();
    }

    @Bean(name="roomEventTopic")
    public Topic snsRoomTopicBuild(){
        return new Topic().withTopicArn(roomArn);
    }




}
