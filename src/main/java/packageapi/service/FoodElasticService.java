package packageapi.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packageapi.models.FoodElastic;
import packageapi.repository.FoodElasticRepository;

@Service
public class FoodElasticService {
	

	@Autowired
	private FoodElasticRepository elasticrepo;

	public List<FoodElastic> getAllFoods(){
		List<FoodElastic> foods = new ArrayList<>();
		elasticrepo.findAll()
		.forEach(foods::add);
		return foods;
	}
	
	public FoodElastic getFood(String id) {

		return elasticrepo.findOne(id);
	}
	
	public List<FoodElastic>getFoodPrice(int min, int max ) {
		
		List<FoodElastic> food = new ArrayList<>();
		elasticrepo.findByPriceBetween(min,max)
		.forEach(food::add);
		return food;
	}

	public void addFood(FoodElastic food) {

		elasticrepo.save(food);
	}

	public void updateFood(FoodElastic food) {

		elasticrepo.save(food);
	}

	public void deleteFood(String id) {

		elasticrepo.delete(id);
	}
}
	
