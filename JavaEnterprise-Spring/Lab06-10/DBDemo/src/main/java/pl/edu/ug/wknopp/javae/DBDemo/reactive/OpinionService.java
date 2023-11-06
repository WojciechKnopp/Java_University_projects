package pl.edu.ug.wknopp.javae.DBDemo.reactive;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;
import java.util.stream.Stream;

@Service
public class OpinionService {
    public Flux<Opinion> opinionStream(){
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(1));

        Random random = new Random();

        Flux<Opinion> opinions = Flux.fromStream(
                Stream.generate(() -> new Opinion(random.nextInt(5) + 1, random.nextInt(5) + 1))
        );

        return Flux.zip(interval, opinions, (i, o) -> o);
    }
}
