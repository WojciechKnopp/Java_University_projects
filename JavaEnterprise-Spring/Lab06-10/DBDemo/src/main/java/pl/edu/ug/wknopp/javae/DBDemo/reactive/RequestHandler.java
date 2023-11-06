package pl.edu.ug.wknopp.javae.DBDemo.reactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
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

}
