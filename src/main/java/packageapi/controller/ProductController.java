package packageapi.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import packageapi.models.Product;
import packageapi.models.ProductElastic;
import packageapi.service.ProductElasticService;
import packageapi.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productservice;
	@Autowired
	private ProductElasticService elasticservice;
	
	ModelMapper modelMapper = new ModelMapper();
	 
	@RequestMapping("/products")
	public List<ProductElastic> getAllProducts(){
    return elasticservice.getAllProducts();
    }
	
	@RequestMapping("/products/{id}")
	public ProductElastic getProduct(@PathVariable String id) {
		return elasticservice.getProduct(id);
	}
	
	@RequestMapping("/products/price/{min}/{max}")
	public List<ProductElastic> getProductByPrice(@PathVariable int min,@PathVariable int max){
	    return elasticservice.getProductPrice(min,max);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/products")
	public void addTopic(@RequestBody Product product) {
		//elasticservice.addTopic(topic);
		productservice.addProduct(product);
		ProductElastic elstictopic = modelMapper.map(product, ProductElastic.class);
		elasticservice.addProduct(elstictopic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}")
	public void updateProduct(@RequestBody Product product, @PathVariable String id) {
		productservice.updateProduct(product);
		ProductElastic elstictopic = modelMapper.map(product, ProductElastic.class);
		elasticservice.updateProduct(elstictopic);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}")
	public void deleteProduct(@PathVariable String id) {
		productservice.deleteProduct(id);
		elasticservice.deleteProduct(id);
		
	}
}

