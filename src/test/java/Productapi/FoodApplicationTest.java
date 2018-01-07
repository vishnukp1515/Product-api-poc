package Productapi;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import packageapi.FoodApplication;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootConfiguration
public class FoodApplicationTest {

        @Test
        public void contextLoads() {
        }
    @Test
    public void test() {
        FoodApplication.main(new String[]{
                "--server.port = 8080",
                "--elasticsearch.port = 9300",
//                "--spring.data.cassandra.port=9042",

        });
    }

}
