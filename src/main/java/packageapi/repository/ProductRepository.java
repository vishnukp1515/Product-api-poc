package packageapi.repository;

import org.springframework.data.repository.CrudRepository;
import packageapi.models.Product;

public interface ProductRepository extends CrudRepository<Product, String> {

}