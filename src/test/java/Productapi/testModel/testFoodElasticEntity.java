package Productapi.testModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import packageapi.models.Food;
import packageapi.models.FoodElastic;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class testFoodElasticEntity {
    ObjectMapper objectMapper = new ObjectMapper();

    @InjectMocks
    FoodElastic food;
    String id="1";

    @Test
    public void testCategory() throws Exception {
        String expectedString = "{\"id\":\"" + id + "\",\"name\":\"lays\",\"price\":20}";
        FoodElastic foodTest = new FoodElastic();
        foodTest.setId("1");
        foodTest.setName("lays");
        foodTest.setPrice(20);
        String testString = objectMapper.writeValueAsString(foodTest);
        assertEquals(expectedString, testString);
    }
}
