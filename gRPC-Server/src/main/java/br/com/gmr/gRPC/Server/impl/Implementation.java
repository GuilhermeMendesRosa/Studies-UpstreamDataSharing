package br.com.gmr.gRPC.Server.impl;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import protobuf.grpc.HelloWorldServiceGrpc;
import protobuf.java.HelloWorld;

@GrpcService
public class Implementation extends HelloWorldServiceGrpc.HelloWorldServiceImplBase {

    @Override
    public io.grpc.stub.StreamObserver<HelloWorld.HelloWorldRequest> sayHello(
            io.grpc.stub.StreamObserver<HelloWorld.HelloWorldResponse> responseObserver) {

        return new StreamObserver<HelloWorld.HelloWorldRequest>() {
            @Override
            public void onNext(HelloWorld.HelloWorldRequest request) {
                // Lógica para processar a requisição do cliente
                HelloWorld.HelloWorldResponse response = HelloWorld.HelloWorldResponse.newBuilder()
                        .setGreeting("Hello World")
                        .build();
                responseObserver.onNext(response);
            }

            @Override
            public void onError(Throwable throwable) {
                // Lógica para lidar com erros
            }

            @Override
            public void onCompleted() {
                // Lógica para finalizar a comunicação com o cliente
                responseObserver.onCompleted();
            }
        };
    }
}
