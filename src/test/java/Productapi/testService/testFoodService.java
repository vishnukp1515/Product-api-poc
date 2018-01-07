package Productapi.testService;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import packageapi.models.Food;
import packageapi.repository.FoodRepository;
import packageapi.service.FoodService;


//import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
public class testFoodService {
 @InjectMocks
    private FoodService foodService;
 @Mock
 FoodRepository foodrepo;

 MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(foodService).build();

    }
    @Test
    public void saveTest() {
        Food foodAppEntityForCassandra = new Food();
        when(foodrepo.save(any(Food.class))).thenReturn(foodAppEntityForCassandra);

        foodService.addFood(foodAppEntityForCassandra);
    }

    @Test
    public void updateTest() {
        Food foodAppEntityForCassandra = new Food();
        when(foodrepo.save(any(Food.class))).thenReturn(foodAppEntityForCassandra);

        foodService.updateFood(foodAppEntityForCassandra);
    }

    @Test
    public void deleteTest() {
        String id = "1";
        foodService.deleteFood(id);
    }


}
