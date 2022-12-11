package ru.billionaire;

import io.grpc.stub.StreamObserver;
import ru.billionaire.grpc.GreetingServiceGrpc;
import ru.billionaire.grpc.GreetingServiceOuterClass;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {

        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            GreetingServiceOuterClass.HelloResponse response =GreetingServiceOuterClass
                    .HelloResponse.newBuilder().setGreeting("Hello from server, " + request.getName()).build();

            responseObserver.onNext(response);

        }

        responseObserver.onCompleted();
    }
}
