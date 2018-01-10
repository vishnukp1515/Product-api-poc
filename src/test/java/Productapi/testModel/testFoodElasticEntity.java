package Productapi.testModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import packageapi.models.FoodElastic;
import packageapi.service.FoodElasticService;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
public class testFoodElasticEntity {
    ObjectMapper objectMapper = new ObjectMapper();
    String id="2";
    @Test
    public void testSomeMethod() {
    FoodElastic component = new FoodElastic("2","lays",5);
    }
    @Test
    public void testCategory() throws Exception {
        String expectedString = "{\"id\":\"" + id + "\",\"name\":\"lays\",\"price\":20}";
        FoodElastic foodTest = new FoodElastic();
        foodTest.setId("2");
        foodTest.setName("lays");
        foodTest.setPrice(20);
        String testString = objectMapper.writeValueAsString(foodTest);
        assertEquals(expectedString, testString);
    }


}
