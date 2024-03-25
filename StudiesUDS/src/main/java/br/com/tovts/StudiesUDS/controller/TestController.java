package br.com.tovts.StudiesUDS.controller;

import br.com.tovts.StudiesUDS.service.TestService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService service;

    @PostMapping
    public ResponseEntity post() {
        Thread thread1 = new Thread(() -> {
            service.saca(10d);
        });

        Thread thread2 = new Thread(() -> {
            service.saca(5d);
        });

        thread1.start();
        thread2.start();

        return ResponseEntity.ok(service.getSaldo().toString());
    }


    @GetMapping
    public ResponseEntity<String> get() {
        service.reset();
        return ResponseEntity.ok().build();
    }
}
