package hafidz.demo;

import hafidz.demo.data.MultiFoo;
import hafidz.demo.repository.CategoryRepository;
import hafidz.demo.repository.CustomerRepository;
import hafidz.demo.repository.ProductRepository;
import hafidz.demo.service.CategoryService;
import hafidz.demo.service.CustomerService;
import hafidz.demo.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {
    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ComponentConfiguration.class);
    }

    @Test
    void componentTest(){
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService",ProductService.class);

        Assertions.assertSame(productService2, productService);
    }

    @Test
    void testConstructorDepedencyInjection(){
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertNotNull(productService.getProductRepository());
        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    @Test
    void testSetterDepedencyInjection(){
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryService.getCategoryRepository(), categoryRepository);
        Assertions.assertNotNull(categoryService.getCategoryRepository());
    }

    @Test
    void testFieldDepedencyInjection(){
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CustomerRepository normalCustomerRepository = applicationContext.getBean("normalCustomerRepository", CustomerRepository.class);
        CustomerRepository premiumCustomerRepository = applicationContext.getBean("premiumCustomerRepository", CustomerRepository.class);

        Assertions.assertSame(normalCustomerRepository, customerService.getNormalCustomerRepository());
        Assertions.assertSame(premiumCustomerRepository, customerService.getPremiumCustomerRepository());
    }

    @Test
    void testObjectProvider(){
        MultiFoo multiFoo = applicationContext.getBean(MultiFoo.class);
        Assertions.assertEquals(3, multiFoo.getFoos().size());
    }
}
