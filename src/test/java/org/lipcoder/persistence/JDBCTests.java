package org.lipcoder.persistence;

import static org.junit.Assert.fail;

import lombok.extern.log4j.Log4j;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;

@Log4j
public class JDBCTests {
    /**
     * JDBC 초기화 테스트
     */

    static {
        /**
         * 해당하는 jdbc 클래스가 있는지 먼저 검사한다.
         */
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testConnection() {

        try (Connection con =
             DriverManager.getConnection(
                 "jdbc:oracle:thin:@localhost:1521:XE",
                 "book_ex",
                 "book_ex")){
            log.info(con);
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }
}
