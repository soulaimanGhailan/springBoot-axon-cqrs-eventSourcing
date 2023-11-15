package micro.axonn.productserviceaxon.queries.controllers;

import lombok.AllArgsConstructor;
import micro.axonn.productserviceaxon.queries.entites.Product;
import micro.axonn.productserviceaxon.queries.queries.GetAllProduct;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/queries/product")
@AllArgsConstructor
public class ProductQueryController {
    private QueryGateway queryGateway;
    @GetMapping("/all")
    public CompletableFuture<List<Product>> products(){
         return queryGateway.query(new GetAllProduct(), ResponseTypes.multipleInstancesOf(Product.class));
    }
}
