package micro.axonn.productserviceaxon.queries.service;

import micro.axonn.productserviceaxon.queries_commands.events.ProductCreatedEvent;
import micro.axonn.productserviceaxon.queries_commands.events.ProductUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.eventhandling.EventMessage;

public interface ProductEventHandlerService {
    @EventHandler
    void onCreated(EventMessage<ProductCreatedEvent> eventMessage);
}

