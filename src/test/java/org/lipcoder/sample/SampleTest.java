package org.lipcoder.sample;

import com.lipcoder.sample.Restaurant;

import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)                                     // 스프링을 실행할 역할을 하겠다.
@ContextConfiguration("classpath:WEB-INF/spring/applicationContext.xml")    // xml설정을 통해 빈을 등록하겠다.
@Log4j      // 자동으로 내부에 Static final로 Logger 인스턴스를 생성해준다.
public class SampleTest {

    @Setter(onMethod_ = {@Autowired})
    private Restaurant restaurant;

    /**
     * 중요한 점
     * 1. 테스트 코드가 실행되기 위해 스프링 프레임워크가 동작하였다.
     * 2. 동작하는 과정에서 필요한 객체들이 스프링 프레임워크에 등록되었다.
     * 3. 의존성 주입이 필요한 객체는 자동으로 주입이 이루어졌다.
     */

    @Test
    public void testExist() {

        // object로 받은 param이 null이 아니어야 테스트가 성공한다.
        assertNotNull(restaurant);

        log.info(restaurant);
        log.info("------------------------------------");
        log.info(restaurant.getChef());

    }
}
