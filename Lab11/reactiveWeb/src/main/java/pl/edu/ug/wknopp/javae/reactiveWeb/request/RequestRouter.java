package pl.edu.ug.wknopp.javae.reactiveWeb.request;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.RouterFunction;

@Configuration
public class RequestRouter {

    @Bean
    RouterFunction<?> routes(RequestHandler requestHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/opinionstream"), requestHandler::opinionStream)
                .andRoute(RequestPredicates.GET("/opinionstream/best"), requestHandler::bestOpinionStream)
                .andRoute(RequestPredicates.GET("/opinionstream/mapped"), requestHandler::mappedOpinion);
    }

}
