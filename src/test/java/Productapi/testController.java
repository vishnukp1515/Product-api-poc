package Productapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import packageapi.controller.FoodController;
import packageapi.models.FoodElastic;
import packageapi.repository.FoodElasticRepository;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;





//import org.springframework.test.context.junit4.*;
//
//import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;





@RunWith(SpringRunner.class)
@WebMvcTest(FoodController.class)
public class testController {


    @Autowired
    private MockMvc mvc;

    @MockBean
    private FoodElasticRepository personRepo;

    @Test
    public void getPersonTest() throws Exception {
        FoodElastic person = new FoodElastic();
        person.setId("1");
        person.setName("John");
        person.setPrice(25);

        given(personRepo.findOne("1")).willReturn(person);
        mvc.perform(get("/foods/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
//                .andExpect(jsonPath("$.id", is("1")))
//                .andExpect(jsonPath("$.name", is("John")))
//                .andExpect(jsonPath("$.price", is(25)));

    }
    @Test
    public void personNotFoundTest() throws Exception {
        mvc.perform(get("/foods/2").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
    }

}
