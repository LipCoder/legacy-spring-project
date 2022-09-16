package org.lipcoder.mapper;

import com.lipcoder.mapper.TimeMapper;
import lombok.Setter;
import lombok.extern.log4j.Log4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:WEB-INF/spring/applicationContext.xml")
@Log4j
public class TimeMapperTests {

    @Setter(onMethod_ = @Autowired)
    private TimeMapper timeMapper;

    @Test
    public void testGetTime2() {
        log.info("getTime");
        log.info(timeMapper.getTime());

        log.info("getTime2");
        log.info(timeMapper.getTime2());
    }
}
