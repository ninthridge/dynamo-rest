package com.ninthridge.dynamorest.config;

import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder.EndpointConfiguration;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

@Configuration
@EnableDynamoDBRepositories(basePackages = "com.ninthridge.dynamorest.repository")
public class DynamoDbConfig {
  
  @Value("${amazon.dynamodb.region}")
  private String region;

  @Bean
  public AmazonDynamoDB amazonDynamoDB() {
    
    AmazonDynamoDBClientBuilder builder = AmazonDynamoDBClientBuilder.standard();
    if("local".equals(region)) {
      builder.withEndpointConfiguration(new EndpointConfiguration("http://localhost:8000", region));
      builder.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("accessKey", "secretKey")));
    }
    else {
      builder.withRegion(region);
    }
    return builder.build();
  }
}
