package hafidz.demo;

import hafidz.demo.data.Bar;
import hafidz.demo.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.Assert;

public class ScopeTest {

    private ApplicationContext applicationContext;

    @BeforeEach
    void setUp(){
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfiguration.class);
    }

    @Test
    void scopeTest(){
        Foo foo1 = applicationContext.getBean("foo1", Foo.class);
        Foo foo2 = applicationContext.getBean("foo2", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
    }

    @Test
    void testDoubletonScope(){
        Bar bar1 = applicationContext.getBean(Bar.class);
        Bar bar2 = applicationContext.getBean(Bar.class);
        Bar bar3 = applicationContext.getBean(Bar.class);
        Bar bar4 = applicationContext.getBean(Bar.class);

        Assertions.assertNotSame(bar1, bar2);
        Assertions.assertSame(bar1, bar3);
        Assertions.assertSame(bar2, bar4);
    }
}
