package com.productservice.productservice;

import com.productservice.productservice.controller.ProductController;
import com.productservice.productservice.dto.ProductRequest;
import com.productservice.productservice.dto.ProductResponse;
import com.productservice.productservice.exception.DefaultException;
import com.productservice.productservice.repository.ProductRepository;
import com.productservice.productservice.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

//@WebMvcTest
@AutoConfigureMockMvc
@SpringBootTest
@Testcontainers
@Slf4j
@ComponentScan (basePackages = "com.productservice.productservice")

public class ProductserviceApplicationTests {
    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");


    @Autowired
    private ProductRepository productRepository;
   @Autowired
    private MockMvc mockMvc;
   @MockBean
   private ProductService productService;
   @MockBean
   private ProductResponse productResponse;
   @Mock
   private ProductController productController;

    @Autowired
    private ObjectMapper objectMapper;


    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }


    @Test
    void testShouldCreateProduct() throws Exception {
        ProductRequest productRequest = getProductRequest();
        String productRequestString = objectMapper.writeValueAsString(productRequest);
        try{
            this.mockMvc.perform(MockMvcRequestBuilders.post("/api/product/product")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(productRequestString)
            );
        } catch(DefaultException exception){
            throw new DefaultException("Exception in program"+exception.getMessage());
        }
        Assertions.assertEquals(1,productRepository.findAll().size());

    }

    @Test
    void testGetProduct() throws Exception{
//        ProductResponse productResponse = new ProductResponse("1","Iphone12","This is produts",565d);
        ProductRequest productRequest = getProductRequest();
         String productRequestString = objectMapper.writeValueAsString(productRequest);
         try{
             Mockito.when(productResponse.getName()).thenReturn(productRequestString);
             this.mockMvc.perform(MockMvcRequestBuilders.get("/api/product/get"));
             Assertions.assertEquals(productResponse.getName(),productRequestString);
             log.info("Get Data{}",productRequestString);
         } catch (DefaultException exception){
                throw new DefaultException("Exception in program"+exception.getMessage());
         }
    }


    private ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name("Iphone")
                .description("This is Iphone1111")
                .price(90d)
                .build();

    }


}
