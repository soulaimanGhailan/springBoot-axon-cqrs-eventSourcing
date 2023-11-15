package micro.axonn.productserviceaxon.queries.service;

import lombok.extern.slf4j.Slf4j;
import micro.axonn.productserviceaxon.queries.entites.Product;
import micro.axonn.productserviceaxon.queries.reposotories.ProductRepo;
import micro.axonn.productserviceaxon.queries_commands.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventMessage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
//@Transactional
@Slf4j
public class ProductEventHandlerServiceImpl implements ProductEventHandlerService {
    private ProductRepo productRepo;

    public ProductEventHandlerServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    // we can use product created event only
    @Override
    public void onCreated(EventMessage<ProductCreatedEvent> eventMessage) {
        log.info("***********************");
        log.info("product creation event received");
        log.info("***********************");
        productRepo.save(Product.builder()
                        .id(eventMessage.getPayload().getId())
                        .addingDate(Date.from(eventMessage.getTimestamp()))
                        .price(eventMessage.getPayload().getPrice())
                        .name(eventMessage.getPayload().getName())
                        .status(eventMessage.getPayload().getStatus())
                .build());
    }

}
