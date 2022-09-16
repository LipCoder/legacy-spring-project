package com.lipcoder.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

    // inner SQL Statement
    @Select("SELECT sysdate FROM dual")
    public String getTime();

    // outer SQL Statement (resources/lipcoder/mapper/TimeMapper.xml)
    public String getTime2();

}
