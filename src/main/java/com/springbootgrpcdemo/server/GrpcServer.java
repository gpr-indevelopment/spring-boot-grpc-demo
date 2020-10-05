package com.springbootgrpcdemo.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;

@Configuration
public class GrpcServer {

    @PostConstruct
    private void startServer() throws InterruptedException, IOException {
        int port = 8080;
        System.out.println("GRPC server started. Listening on port: " + port);
        Server server = ServerBuilder
                .forPort(port)
                .addService(new MainServiceImpl())
                .build();
        server.start();
        server.awaitTermination();
    }
}
