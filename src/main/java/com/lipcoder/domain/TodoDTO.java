package com.lipcoder.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {

    private String title;

    /**
     * @DateTimeFormat
     * @InitBinder 대신 날짜 변환을 가능하게 해주는 어노테이션
     * 만약 @InitBinder 가 있다면 무시된다.
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date dueDate;
}
