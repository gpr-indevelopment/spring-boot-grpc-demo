package com.springbootgrpcdemo.server;

import com.springbootgrpcdemo.HelloRequest;
import com.springbootgrpcdemo.HelloResponse;
import com.springbootgrpcdemo.MainServiceGrpc;
import io.grpc.stub.StreamObserver;

public class MainServiceImpl extends MainServiceGrpc.MainServiceImplBase {

    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = String.format("Some greeting for %s %s.", request.getFirstName(), request.getLastName());
        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
