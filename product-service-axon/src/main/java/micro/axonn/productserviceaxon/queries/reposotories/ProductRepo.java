package micro.axonn.productserviceaxon.queries.reposotories;

import micro.axonn.productserviceaxon.queries.entites.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product , String> {
}
