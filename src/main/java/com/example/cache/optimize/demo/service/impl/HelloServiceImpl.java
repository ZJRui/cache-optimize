package com.example.cache.optimize.demo.service.impl;

import com.example.cache.optimize.demo.entity.Student;
import com.example.cache.optimize.demo.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class HelloServiceImpl implements HelloService {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    @Override
    public String hello() {
        if (!TransactionSynchronizationManager.isActualTransactionActive()) {
            throw new IllegalStateException("Expected transaction to be active!");
        }


        String sql = "select * from objecttype where oid=?";
        final Student student = new Student();
        jdbcTemplate.query(sql, new Object[]{133267L}, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                student.setName(resultSet.getString("name"));
            }
        });

        return "hello";
    }

}
