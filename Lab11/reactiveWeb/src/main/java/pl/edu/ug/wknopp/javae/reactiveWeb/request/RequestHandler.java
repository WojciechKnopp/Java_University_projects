package pl.edu.ug.wknopp.javae.reactiveWeb.request;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import pl.edu.ug.wknopp.javae.reactiveWeb.domain.Opinion;
import pl.edu.ug.wknopp.javae.reactiveWeb.service.OpinionService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class RequestHandler {

    private final OpinionService opinionService;

    public RequestHandler(OpinionService opinionService) {
        this.opinionService = opinionService;
    }

    public Mono<ServerResponse> opinionStream(ServerRequest request) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(opinionService.opinionStream(), Opinion.class);
    }

    public Mono<ServerResponse> bestOpinionStream(ServerRequest request) {
        Flux<Opinion> bestOpinionStream = opinionService.opinionStream()
                .filter(opinion -> opinion.getRating() > 3);

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(bestOpinionStream, Opinion.class);
    }

    public Mono<ServerResponse> mappedOpinion(ServerRequest request) {
        Flux<String> opinionStream = opinionService.opinionStream()
                .map(opinion -> "Opinion: " + opinion.getRating() + " stars");

        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(opinionStream, Opinion.class);
    }


}
