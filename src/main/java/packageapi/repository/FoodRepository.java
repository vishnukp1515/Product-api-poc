package packageapi.repository;

import org.springframework.data.repository.CrudRepository;
import packageapi.models.Food;

public interface FoodRepository extends CrudRepository<Food, String> {

}