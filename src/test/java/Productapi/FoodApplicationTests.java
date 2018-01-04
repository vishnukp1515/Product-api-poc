package Productapi;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;


import packageapi.FoodApplication;
import packageapi.models.FoodElastic;
import packageapi.service.FoodElasticService;
import packageapi.repository.FoodElasticRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
//@WebMvcTest(value=ProductController.class, secure = false)
@SpringBootTest(classes = FoodApplication.class)
public class FoodApplicationTests {

//	@Autowired
//	private MockMvc mockMvc;
//
//	@Autowired
//    private FoodElasticService elasticService;
//
//    @Autowired
//    private FoodElasticRepository elasticrepo;
////
//    @Autowired
//    private ElasticsearchTemplate esTemplate;


//    @Before
//    public void before() {
//        esTemplate.deleteIndex(FoodElastic.class);
//        esTemplate.createIndex(FoodElastic.class);
//        esTemplate.putMapping(FoodElastic.class);
//        esTemplate.refresh(FoodElastic.class);
//    }

//  @Before
//  public void prepare() {
//    elasticrepo = mock(FoodElasticRepository.class);
//    elasticService = new FoodElasticService(elasticrepo);
//  }
//
//
//
//  @Test
//  public void findBuddyTest() {
//    List<FoodElastic> people = new ArrayList<FoodElastic>();
//
//    FoodElastic p1 = new FoodElastic();
//    p1.setId("5");
//    p1.setName("John");
//    p1.setPrice(20);
//    people.add(p1);
//
//    FoodElastic p2 = new FoodElastic();
//    p2.setId("7");
//    p2.setName("Joh");
//    p2.setPrice(40);
//    people.add(p2);
//
//    FoodElastic p3 = new FoodElastic();
//    p1.setId("9");
//    p1.setName("Jo");
//    p1.setPrice(60);
//    people.add(p3);
//
//    elasticrepo.findAll();
//
//    //when(elasticrepo.findAll()).thenReturn(people);
//
////    assertEquals(elasticService.findBuddy(p1), p2);
//  }
//







//    @Test
//    public void testFindOne() {
//
//    }








//    ProductElastic mockCourse = new ProductElastic("C1", "Spring", 33);
//
//	String exampleCourseJson = "{\"name\":\"Spring\",\"price\":\"33\"}";

//	@Test
//	public void testretrieveDetails() throws Exception{
//		System.out.println("hell");
//
//		Mockito.when(
//				elasticService.getProduct(Mockito.anyString())).thenReturn(mockCourse);
//		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
//				"/products/C1");
//		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
//
//		System.out.println("hello");
//		System.out.println(result.getResponse());
//		String expected = "{id:C1,name:Spring,price:33}";
//
//		// {"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
//
//		JSONAssert.assertEquals(expected, result.getResponse()
//				.getContentAsString(), false);
//	}

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
//  @Test
//    public void testSave() {
//
//        FoodElastic book = new FoodElastic("1001", "Elasticsearch Basics", 75);
//        FoodElastic testBook = elasticrepo.save(book);
//
//        assertNotNull(testBook.getId());
//        assertEquals(testBook.getName(),book.getName());
//        assertEquals(testBook.getPrice(),book.getPrice());
//
//      }

//
}
