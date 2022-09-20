package com.lipcoder.controller;

import com.lipcoder.domain.SampleDTO;
import com.lipcoder.domain.SampleDTOList;
import com.lipcoder.domain.TodoDTO;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;

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

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids) {

        log.info("ids ==> " + Arrays.toString(ids));

        return "ex02Array";
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list) {

        log.info("dto list ==> " + list);

        return "ex02Bean";
    }

    /**
     * @InitBinder
     *
     * Spring은 자동으로 받은 데이터를 수집하여 변환하는 역할을 하지만,
     * 때때로 이 작업을 직접 해줘야 적용되는 경우가 있다.
     * 예를 들면, 1992-12-04 의 문자열을 Date 객체 형식으로 변환하는 경우가 있다.
     *
     * 이때 사용할 수 있는 것이 @InitBinder 이다.
     */
    @InitBinder
    public void initBuilder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(java.util.Date.class,
                new CustomDateEditor(dateFormat, false));
    }
    @GetMapping("/ex03")
    public String ex03(TodoDTO todo) {
        log.info(todo);
        return "ex03";
    }

    /**
     * Model 이라는 데이터 전달자
     *
     * Model 객체는 JSP에 컨트롤러에서 생성된 데이터를 담아 전달하는 역할을 하는 존재
     * 즉, 뷰(View)로 보낼 데이터를 담아 보낸다.
     */
    // 기존 서블릿 방식
    private void doGet(HttpServletRequest request, HttpServletResponse response)
       throws javax.servlet.ServletException, java.io.IOException {

        request.setAttribute("serverTime", new java.util.Date());

        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        dispatcher.forward(request, response);
    }

    // 스프링 방식
    @GetMapping("/ex04Model")
    public String home(Model model) {

        model.addAttribute("serverTime", new java.util.Date());
        return "home";
    }

    /**
     * @ModelAttribute
     *
     * 스프링 MVC는 기본적으로 Java Beans 규칙에 맞는 객체를 다시 화면으로 객체를 전달한다.
     * [ 좁은 의미에서 Java Beans의 규칙은 단순히 생성자가 없거나 빈 생성자를 가져야 하며,
     *   getter/setter를 가진 클래스 (POJO 방식) ]
     *
     * @ModelAttribute 는 강제로 전달받은 파라미터를 Model에 담아 전달하도록 할 때 필요한 어노테이션이다.
     * @ModelAttribute 가 걸린 파라미터는 타입에 관계없이 무조건 Model에 담아 전달되므로,
     * 파라미터로 전달된 데이터를 다시 화면에서 사용해야 할 경우에 유용하게 사용된다.
     *
     */
    @GetMapping("/ex04")
    public String ex04(SampleDTO dto, @ModelAttribute("page") int page) {

        log.info("dto: " + dto);

        // @ModelAttribute가 없으면...
        // 기본 자료형은 파라미터로 선언하여도 화면까지 데이터가 전달되지 않는다.
        log.info("page: " + page);

        return "ex04";
    }

    /**
     * RedirectAttributes
     *
     * 일회성으로 데이터를 전달하는 용도로 사용된다.
     *
     * 기존 서블릿 방식
     * ==> response.sendRedirect("/home?name=aaa&age=10");
     *
     * 스프링 방식
     * rttr.addFlashAttribute("name", "AAA");
     * rttr.addFlashAttribute("age", 10);
     * return "redirect:/";
     */

}
