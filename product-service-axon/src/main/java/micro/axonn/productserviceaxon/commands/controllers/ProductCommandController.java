package micro.axonn.productserviceaxon.commands.controllers;

import lombok.AllArgsConstructor;
import micro.axonn.productserviceaxon.queries_commands.DTOs.CreateProductReqDTO;
import micro.axonn.productserviceaxon.queries_commands.DTOs.UpdateProductDto;
import micro.axonn.productserviceaxon.queries_commands.commands.CreateProductCommand;
import micro.axonn.productserviceaxon.queries_commands.commands.UpdateProductCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/commands/product")
@AllArgsConstructor
public class ProductCommandController {
    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public CompletableFuture<String> createProd(@RequestBody CreateProductReqDTO reqDTO){
       return commandGateway.send(new CreateProductCommand(UUID.randomUUID().toString() , reqDTO.getPrice() , reqDTO.getName()));
    }
    @PutMapping("/update")
    public CompletableFuture<String> updateProduct(@RequestBody UpdateProductDto updateProductDto){
        return commandGateway.send(
                new UpdateProductCommand(updateProductDto.getProductId() ,
                        updateProductDto.getName() ,
                        updateProductDto.getPrice())) ;
    }


    @GetMapping("/eventStore/{id}")
    public Stream eventStream(@PathVariable String id){
        return  eventStore.readEvents(id).asStream();
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception exception){
        return new ResponseEntity<>(exception.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
