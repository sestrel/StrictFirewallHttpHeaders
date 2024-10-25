package app;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class MyController
{

    @GetMapping("/mycontroller")
    public Mono<ResponseEntity<String>> get()
    {
    	return Mono.just(ResponseEntity.ok().body("result"));
    }

}
