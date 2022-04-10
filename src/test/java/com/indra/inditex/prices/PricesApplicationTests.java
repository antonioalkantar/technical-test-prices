package com.indra.inditex.prices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@TestPropertySource(locations = "classpath:application.properties")
@AutoConfigureMockMvc
class PricesApplicationTests {
	
	private static final Logger logger = LoggerFactory.getLogger(PricesApplicationTests.class);
    
    @Autowired
    private MockMvc mockMvc;
    
    /**
	 * Test 1 @param startDate = peticion a las 10:00 del dia 14
	 * Test 1 @param productId = 35455 
	 * Test 1 @param brandId = 1
	 */
    @Test
    public void test1Search() throws Exception {
        String response = mockMvc.perform(get("http://localhost:8080/api/prices/search?applicationDate=2020-06-14 10:00:00&productId=35455&brandId=1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("Response Test1: " + response);
    }
    
    /**
	 * Test 1 @param startDate = peticion a las 16:00 del dia 14
	 * Test 1 @param productId = 35455 
	 * Test 1 @param brandId = 1
	 */
    @Test
    public void test2Search() throws Exception {
        String response = mockMvc.perform(get("http://localhost:8080/api/prices/search?applicationDate=2020-06-14 16:00:00&productId=35455&brandId=1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("Response Test2: " + response);
    }
    
    /**
	 * Test 1 @param startDate = peticion a las 21:00 del dia 14
	 * Test 1 @param productId = 35455 
	 * Test 1 @param brandId = 1
	 */
    @Test
    public void test3Search() throws Exception {
        String response = mockMvc.perform(get("http://localhost:8080/api/prices/search?applicationDate=2020-06-14 21:00:00&productId=35455&brandId=1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("Response Test3: " + response);
    }
    
    /**
	 * Test 1 @param startDate = peticion a las 10:00 del dia 15
	 * Test 1 @param productId = 35455 
	 * Test 1 @param brandId = 1
	 */
    @Test
    public void test4Search() throws Exception {
        String response = mockMvc.perform(get("http://localhost:8080/api/prices/search?applicationDate=2020-06-15 10:00:00&productId=35455&brandId=1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("Response Test4: " + response);
    }
    
    /**
	 * Test 1 @param startDate = peticion a las 21:00 del dia 16
	 * Test 1 @param productId = 35455 
	 * Test 1 @param brandId = 1
	 */
    @Test
    public void test5Search() throws Exception {
        String response = mockMvc.perform(get("http://localhost:8080/api/prices/search?applicationDate=2020-06-16 21:00:00&productId=35455&brandId=1"))
                .andExpect(status().is(HttpStatus.OK.value()))
                .andReturn().getResponse().getContentAsString();
 
        logger.info("Response Test5: " + response);
    }

}
