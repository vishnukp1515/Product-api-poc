package packageapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packageapi.models.ProductElastic;
import packageapi.repository.ProductElasticRepository;

@Service
public class ProductElasticService {
	

	@Autowired
	private ProductElasticRepository elasticrepo;
	
	public List<ProductElastic> getAllProducts(){
		List<ProductElastic> products = new ArrayList<>();
		elasticrepo.findAll()
		.forEach(products::add);
		return products;
	}
	
	public ProductElastic getProduct(String id) {

		return elasticrepo.findOne(id);
	}
	
	public List<ProductElastic>getProductPrice(int min, int max ) {
		
		List<ProductElastic> product = new ArrayList<>();
		elasticrepo.findByPriceBetween(min,max)
		.forEach(product::add);
		return product;	
	}

	public void addProduct(ProductElastic products) {

		elasticrepo.save(products);
	}

	public void updateProduct(ProductElastic products) {

		elasticrepo.save(products);
	}

	public void deleteProduct(String id) {

		elasticrepo.delete(id);
	}
}
	
