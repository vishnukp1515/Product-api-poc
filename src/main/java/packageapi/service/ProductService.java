package packageapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packageapi.models.Product;
import packageapi.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productrepo;

	public void addProduct(Product products) {
		productrepo.save(products);		
	}

	public void updateProduct(Product products) {
		productrepo.save(products);
	}

	public void deleteProduct(String id) {
		productrepo.delete(id);
	}
}
	
