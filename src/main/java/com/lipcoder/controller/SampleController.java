package com.lipcoder.controller;

import com.lipcoder.domain.SampleDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

/**
 * @Controller : Spring에 Controller로 Servlet Bean을 등록한다.
 *      dispatcher-servlet.xml의 component-scan 설정을 통해
 *      스프링이 해당 어노테이션이 있으면 Bean으로 자동 등록한다.
 */
@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
    @RequestMapping("")
    public void basic() {
        log.info("basic.....................");
    }

    /**
     * 좀 더 간단한 어노테이션으로 RequestMapping을 표현할 수 있다.
     * 간편하지만, 기능에 대한 제약이 많다고 느낄 수도 있다.
     * @GetMapping
     * @PostMapping
     *
     */
    @GetMapping("/basicOnlyGet")
    public void basticGet2() {
        log.info("basic get only get...................");
    }

    /**
     * Controller를 작성할 때 가장 편리한 기능은 파라미터가 자동으로 수집된다는 것이다.
     * 어떻게 수집될 것인지를 판단하기 위해서, 작성하는 클래스가 바로 DTO(Data Transform Object)이다.
     */
    @GetMapping("/ex01")
    public String ex01(SampleDTO dto) {

        log.info("" + dto);

        return "ex01";
    }

    /**
     * Controller가 파라미터를 수집하는 과정에서 DTO 타입에 맞게 자동으로 변환하는 방식을 사용한다.
     * 직접 타입을 설정할 수도 있다.
     */
    @GetMapping("/ex02")
    public String ex02(@RequestParam("name") String name,
                       @RequestParam("age") int age) {
        log.info("name: " + name);
        log.info("age: " + age);

        return "ex02";
    }

    /**
     * Controller는 List, Array를 파라미터로 처리할 수 있다.
     */
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids) {

        log.info("ids ==> " + ids);

        return "ex02List";
    }
}
