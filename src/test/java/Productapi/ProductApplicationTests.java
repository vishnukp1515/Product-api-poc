package Productapi;


import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import packageapi.ProductApplication;
import packageapi.controller.ProductController;
import packageapi.models.ProductElastic;
import packageapi.service.ProductElasticService;

@RunWith(SpringRunner.class)
@WebMvcTest(value=ProductController.class, secure = false)
//@SpringBootTest(classes = ProductApplication.class)
public class ProductApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
    private ProductElasticService elasticService;

//    @Autowired
//    private ElasticsearchTemplate esTemplate;


//    @Before
//    public void before() {
//        esTemplate.deleteIndex(ProductElastic.class);
//        esTemplate.createIndex(ProductElastic.class);
//        esTemplate.putMapping(ProductElastic.class);
//        esTemplate.refresh(ProductElastic.class);
//    }

    ProductElastic mockCourse = new ProductElastic("C1", "Spring", 33);

	String exampleCourseJson = "{\"name\":\"Spring\",\"price\":\"33\"}";

	@Test
	public void testretrieveDetails() throws Exception{
		System.out.println("hell");

		Mockito.when(
				elasticService.getProduct(Mockito.anyString())).thenReturn(mockCourse);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/products/C1");
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		System.out.println("hello");
		System.out.println(result.getResponse());
		String expected = "{id:C1,name:Spring,price:33}";

		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}

		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}

//    @Test
//    public void createStudentCourse() throws Exception {
//        ProductElastic mockCourse = new ProductElastic("11", "Smallest Number", 100);
//
//        // studentService.addCourse to respond back with mockCourse
//        Mockito.when(
//                elasticService.addProduct(Mockito.any(ProductElastic.class))).thenReturn(mockCourse);
//
//        // Send course as body to /students/Student1/courses
//        RequestBuilder requestBuilder = MockMvcRequestBuilders
//                .post("/students/Student1/courses")
//                .accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
//                .contentType(MediaType.APPLICATION_JSON);
//
//        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//        MockHttpServletResponse response = result.getResponse();
//
//        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
//
//        assertEquals("http://localhost/students/Student1/courses/1",
//                response.getHeader(HttpHeaders.LOCATION));
//
//    }


//	@Test
//    public void testFindOne() {
//
//        ProductElastic tag = new ProductElastic();
//        tag.setId("10");
//        tag.setName("tech");
//        tag.setPrice(70);
//
//    }

}
