package com.xav.codeproject.dao;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class AlphaDaoMyBatislmpl implements AlphaDao {
    public String select() {
        return "MyBatis";
    }
}
