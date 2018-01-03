package packageapi.repository;

import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import packageapi.models.ProductElastic;

public interface ProductElasticRepository extends ElasticsearchRepository<ProductElastic, String> {
	public List<ProductElastic> findByPriceBetween(int min,int max);

}
