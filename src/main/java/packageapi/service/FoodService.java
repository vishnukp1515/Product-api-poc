package packageapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import packageapi.models.Food;
import packageapi.repository.FoodRepository;

@Service
public class FoodService {
	
	@Autowired
	private FoodRepository foodrepo;

	public void addFood(Food food) {

		foodrepo.save(food);
	}

	public void updateFood(Food food) {

		foodrepo.save(food);
	}

	public void deleteFood(String food) {

		foodrepo.delete(food);
	}
}
	
