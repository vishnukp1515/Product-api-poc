package Productapi.testService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import packageapi.models.FoodElastic;
import packageapi.repository.FoodElasticRepository;
import packageapi.service.FoodElasticService;


import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(SpringRunner.class)
public class testFoodElasticService {
    @InjectMocks
    private FoodElasticService foodService;
    @Mock
    FoodElasticRepository foodrepo;

    MockMvc mockMvc;

    @Before
    public void setup() throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(foodService).build();

    }
    @Test
    public void saveTest() {
        FoodElastic foodAppEntityForElastic = new FoodElastic();
        when(foodrepo.save(any(FoodElastic.class))).thenReturn(foodAppEntityForElastic);

        foodService.addFood(foodAppEntityForElastic);
    }

    @Test
    public void updateTest() {
        FoodElastic foodAppEntityForElastic = new FoodElastic();
        when(foodrepo.save(any(FoodElastic.class))).thenReturn(foodAppEntityForElastic);

        foodService.updateFood(foodAppEntityForElastic);
    }

    @Test
    public void getOneTest() {
        String id = "1";
        foodService.getFood(id);
    }

    @Test
    public void getAllTest() {
        foodService.getAllFoods();
    }

    @Test
    public void deleteTest() {
        String id = "1";
        foodService.deleteFood(id);
    }

    @Test
    public void getFoodPrice() {
        int min=20;
        int max=40;
        foodService.getFoodPrice(min,max);
    }




}
