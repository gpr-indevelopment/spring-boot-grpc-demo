package com.springbootgrpcdemo.client;

import com.springbootgrpcdemo.HelloRequest;
import com.springbootgrpcdemo.HelloResponse;
import com.springbootgrpcdemo.MainServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class GrpcClient {

    @PostConstruct
    private void startClient() {
        System.out.println("Starting client...");
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();
        MainServiceGrpc.MainServiceBlockingStub stub = MainServiceGrpc.newBlockingStub(channel);
        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Gabriel")
                .setLastName("Robaina")
                .build());
        System.out.println(helloResponse.getGreeting());
        channel.shutdown();
    }
}
