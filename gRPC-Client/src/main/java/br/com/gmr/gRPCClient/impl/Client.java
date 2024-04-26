package br.com.gmr.gRPCClient.impl;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Component;
import protobuf.grpc.HelloWorldServiceGrpc;
import protobuf.java.HelloWorld;

import javax.annotation.PostConstruct;

@Component
public class Client {


    @PostConstruct
    public void sayHello() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 9190)
                .usePlaintext() // Usar comunicação não criptografada para simplificar (não recomendado em produção)
                .build();

        HelloWorldServiceGrpc.HelloWorldServiceStub stub = HelloWorldServiceGrpc.newStub(channel);

        HelloWorld.HelloWorldRequest request = HelloWorld.HelloWorldRequest.newBuilder().setName("Guilherme").build();

        stub.sayHello(new StreamObserver<HelloWorld.HelloWorldResponse>() {
            @Override
            public void onNext(HelloWorld.HelloWorldResponse helloWorldResponse) {
                System.out.printf(helloWorldResponse.getGreeting());
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("oi");
            }
        });
    }

}
