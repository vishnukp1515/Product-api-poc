package packageapi.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import packageapi.models.FoodElastic;

public interface FoodElasticRepository extends ElasticsearchRepository<FoodElastic, String> {
	public List<FoodElastic> findByPriceBetween(int min, int max);

}
