package br.com.diego.entrypoint;

import io.smallrye.mutiny.Multi;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.jboss.logging.Logger;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

import static jakarta.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/api/heroes")
@Produces(APPLICATION_JSON)
public class HeroesEntrypoint {
    private static final Logger LOG = Logger.getLogger(HeroesEntrypoint.class);

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> streamEvents() {
        AtomicInteger counter = new AtomicInteger();
        return Multi.createFrom().ticks().every(Duration.ofSeconds(1))
                .onItem().transform(tick -> "Event " + counter.incrementAndGet())
                .onSubscription().invoke(() -> LOG.info("Subscription started"))
                .onTermination().invoke(() -> LOG.info("Subscription terminated"));
    }
}