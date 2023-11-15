package micro.axonn.productserviceaxon.queries.service;

import micro.axonn.productserviceaxon.queries.entites.Product;
import micro.axonn.productserviceaxon.queries.queries.GetAllProduct;
import org.axonframework.queryhandling.QueryHandler;

import java.util.List;

public interface ProductQueryHandlerService {
    @QueryHandler
    List<Product> onGetAllProduct(GetAllProduct query);
}
