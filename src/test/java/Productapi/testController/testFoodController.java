package Productapi.testController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import packageapi.controller.FoodController;
import packageapi.models.Food;
import packageapi.models.FoodElastic;
import packageapi.service.FoodElasticService;
import packageapi.service.FoodService;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@RunWith(MockitoJUnitRunner.class)
public class testFoodController {

    @InjectMocks
    FoodController foodController;

    @Mock
    FoodService foodService;

    @Mock
    FoodElasticService foodServiceElastic;



    private MockMvc mockMvc;

    String json = "{\"id\":\"1\",\"name\":\"lays\",\"price\":20}";

    @Before
    public void setup() throws Exception {
        initMocks(this);
        mockMvc = standaloneSetup(foodController).build();
    }

    @Test
    public void testPost() throws Exception {
        MvcResult result = mockMvc.perform(post("/foods")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testUpdate() throws Exception {
        MvcResult result = mockMvc.perform(put("/foods/1")
                .accept(MediaType.APPLICATION_JSON)
                .content(json)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }


    @Test
    public void retrieveDetailsForCourse() throws Exception {

        foodServiceElastic.getFood(anyString());

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/foods/1").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println(result.getResponse());
        String expected = "{id:1,name:burger,price:60}";
        System.out.println(result.getResponse());

        // {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

        JSONAssert.assertEquals(expected, result.getResponse()
                .getContentAsString(), false);
    }





}



//    @Test
//    public void testGetAll() throws Exception {
//        MvcResult result = mockMvc.perform(get("/foods")
//                .accept(MediaType.APPLICATION_JSON)
//                .content(json)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//        foodServiceElastic.getAllFoods();
//    }
//
//    @Test
//    public void testGetOne() throws Exception {
//        String id = "1";
//        MvcResult result = mockMvc.perform(get("/foods/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .content(json)
//                .contentType(MediaType.APPLICATION_JSON))
//                .andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//        foodServiceElastic.getFood(id);
//    }


//    @Test
//    public void testPromotionControllerResponse() throws Exception {
////        String id = "1";
//        FoodElastic foodAppEntityForElastic = new FoodElastic();
//
//        when(foodServiceElastic.getFood(any())).thenReturn(foodAppEntityForElastic);
////        foodServiceElastic.getFood(id);
//        MvcResult result = mockMvc.perform(get("/foods/1")
//                .accept(MediaType.APPLICATION_JSON)
//                .param("id", "1")
//                .contentType(MediaType.APPLICATION_JSON)).andReturn();
//        MockHttpServletResponse response = result.getResponse();
//        assertEquals(HttpStatus.OK.value(), response.getStatus());
//    }


//@Test
//public void getPersonTest() throws Exception {
//    FoodElastic foodAppEntityForElastic = new FoodElastic();
//    foodAppEntityForElastic.setId("1");
//    foodAppEntityForElastic.setName("lays");
//    foodAppEntityForElastic.setPrice(25);
//
//    given(foodServiceElastic.getFood("1")).willReturn(foodAppEntityForElastic);
//    mockMvc.perform(get("/foods/1").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk());
////            .andExpect((ResultMatcher) jsonPath("$.id", is("1")))
////            .andExpect((ResultMatcher) jsonPath("$.name", is("lays")))
////            .andExpect((ResultMatcher) jsonPath("$.price", is(25)));
//}
//
////    @Test
////    public void personNotFoundTest() throws Exception {
////        mockMvc.perform(get("/foods/200").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isNotFound());
////    }