package Productapi.testModel;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import packageapi.models.Food;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class testFoodEntity {

    ObjectMapper objectMapper = new ObjectMapper();
    @InjectMocks
    Food food;

    @Test
    public void testCategory() throws Exception {
        String expectedString = "{\"id\":\"1\",\"name\":\"lays\",\"price\":20}";
        Food foodTest = new Food();
        foodTest.setId("1");
        foodTest.setName("lays");
        foodTest.setPrice(20);
        String testString = objectMapper.writeValueAsString(foodTest);
        assertEquals(expectedString, testString);
    }
}
