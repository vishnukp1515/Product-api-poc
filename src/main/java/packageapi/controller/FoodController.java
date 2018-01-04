package packageapi.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import packageapi.models.Food;
import packageapi.models.FoodElastic;
import packageapi.service.FoodElasticService;
import packageapi.service.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	private FoodService foodservice;
	@Autowired
	private FoodElasticService elasticservice;
	
	ModelMapper modelMapper = new ModelMapper();
	 
	@RequestMapping(method=RequestMethod.GET, value="/foods")
	public List<FoodElastic> getAll(){

		return elasticservice.getAllFoods();
    }
	
	@RequestMapping(method=RequestMethod.GET, value="/foods/{id}")
	public FoodElastic getOneFood(@PathVariable String id) {
		return elasticservice.getFood(id);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/foods/price/{min}/{max}")
	public List<FoodElastic> getFoodByPrice(@PathVariable int min, @PathVariable int max){
	    return elasticservice.getFoodPrice(min,max);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/foods")
	public void addOneFood(@RequestBody Food food) {
		foodservice.addFood(food);
		FoodElastic elasticfood = modelMapper.map(food, FoodElastic.class);
		elasticservice.addFood(elasticfood);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/foods/{id}")
	public void updateOneFood(@RequestBody Food food, @PathVariable String id) {
		foodservice.updateFood(food);
		FoodElastic elasticfood = modelMapper.map(food, FoodElastic.class);
		elasticservice.updateFood(elasticfood);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/foods/{id}")
	public void deleteOneFood(@PathVariable String id) {
		foodservice.deleteFood(id);
		elasticservice.deleteFood(id);
		
	}
}

