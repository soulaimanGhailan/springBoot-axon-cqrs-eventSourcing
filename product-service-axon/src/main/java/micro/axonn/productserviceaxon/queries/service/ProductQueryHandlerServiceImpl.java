package micro.axonn.productserviceaxon.queries.service;

import micro.axonn.productserviceaxon.queries.entites.Product;
import micro.axonn.productserviceaxon.queries.queries.GetAllProduct;
import micro.axonn.productserviceaxon.queries.reposotories.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductQueryHandlerServiceImpl implements ProductQueryHandlerService {
    private ProductRepo productRepo ;

    public ProductQueryHandlerServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public List<Product> onGetAllProduct(GetAllProduct query) {
        return productRepo.findAll();
    }
}
