package com.xav.codeproject.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate")
public class AlphaDaoHibernatelmpl implements AlphaDao{
    public String select() {
        return "Hibernate";
    }
}
