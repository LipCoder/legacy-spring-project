package com.lipcoder.sample;

import lombok.Data;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 스프링 빈 인식 어노테이션
 * 스프링에서 객체로 관리하는 대상임을 명시
 * <ComponentScan> 태그를 사용하여 지정된 패키지의 자바 코드를 검사하면서
 * @Component 가 붙은 클래스를 스캔하여 빈으로 등록한다.
 */
@Component
/**
 * 롬복 인식 어노테이션, 용세부적인 설정을 하지 않는 일반적인 경우 사
 * 다음 어노테이션들의 집합이다.
 * @ToString
 * @EqualsAndHashCode
 * @Getter/@Setter
 * @RequiredArgsConstructor
 */
@Data
public class Restaurant {
    // Restaurant 객체는 Chef 객체를 필요로 한다.

    /** @Autowired : 스프링은 관리가 필요한 객체(Bean)를 어노테이션 등을 이용해
     *              객체를 생성하고 관리하는 일종의 '컨테이너'나 '팩토리' 기능을 가지고 있다.
     *              또한 개발자가 직접 객체들과의 관계를 관리하지 않고, 자동으로 관리되도록 한다.
     *
     *  @Setter : 컴파일시 자동으로 setChef()를 생성한다.
     *            onMethod를 사용하여 Setter에 @Autowired를 추가한다.
     *            (jdk 1.8 부터는 onMethod_로 대체된다)
     */
    @Setter(onMethod_ = @Autowired)
    private Chef chef;

//    // 스프링 4.3 버전 이후부터는 Setter만 사용해도 묵시적인 의존성 주입을 해준다.
//    public Restaurant(Chef chef) {
//        this.chef = chef;
//    }
}
