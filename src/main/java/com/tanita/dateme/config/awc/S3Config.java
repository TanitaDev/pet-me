package com.tanita.dateme.config.awc;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class S3Config {

    @Value("${storage.s3.credentials.access-key}")
    private String awsAccessKey;

    @Value("${storage.s3.credentials.secret-key}")
    private String awsSecretKey;

    @Value("${storage.s3.region.static}")
    private String region;

    @Value("${storage.s3.host}")
    private String host;

    @Bean
    public AmazonS3 s3client() {
        BasicAWSCredentials credentials = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        return AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(host, region))
                .withClientConfiguration(s3ClientConfiguration())
                .withPathStyleAccessEnabled(true)
                .build();
    }

    @Bean
    @ConfigurationProperties(prefix = "s3.client")
    ClientConfiguration s3ClientConfiguration() {
        return new ClientConfiguration();
    }

}
