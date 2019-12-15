package com.example.exampleflowableautowiredelegates;

import java.util.stream.IntStream;

import org.flowable.engine.RuntimeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExampleFlowableAutowireDelegatesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleFlowableAutowireDelegatesApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(RuntimeService runtimeService){
        return args -> {
            // Starts five instances of the test process
            IntStream.range(0, 5).forEach(value -> {
                runtimeService.startProcessInstanceByKey("testProcess");
            });
        };
    }
}
