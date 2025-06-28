package lv.gderuki.gateway.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GatewayController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/transaction")
    public ResponseEntity<String> send(@RequestBody String body) {
        kafkaTemplate.send("transactions", body);
        return ResponseEntity.ok("Sent to Kafka");
    }
}

