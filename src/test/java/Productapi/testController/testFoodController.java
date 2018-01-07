package Productapi.testController;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import packageapi.controller.FoodController;
import packageapi.service.FoodElasticService;
import packageapi.service.FoodService;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
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
    public void testGetAll() throws Exception {
        MvcResult result = mockMvc.perform(get("/foods")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetOne() throws Exception {
        MvcResult result = mockMvc.perform(get("/foods/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    @Test
    public void testGetPrice() throws Exception {
        MvcResult result = mockMvc.perform(get("/foods/price/20/40")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
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
    public void testDelete() throws Exception {
        MvcResult result = mockMvc.perform(delete("/foods/1")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }




}


