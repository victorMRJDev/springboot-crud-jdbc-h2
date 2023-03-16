package com.example.crudjdbc.dao;


import com.example.crudjdbc.entity.UserA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private static final String INSERT_USER_QUERY = "INSERT INTO userA(id, fname, lname, email) values (?, ?, ?, ?)";
    private static final String UPDATE_USER_QUERY = "UPDATE userA SET fname = ? WHERE id = ?";
    private static final String GET_USER_BY_ID_QUERY = "SELECT * FROM userA WHERE id = ?";
    private static final String DELETED_USER_BY_ID_QUERY = "DELETE FROM userA WHERE id = ?";
    private static final String GET_ALL_USERS_QUERY = "SELECT * FROM userA";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserA saveUser(UserA userA) {
        jdbcTemplate.update(INSERT_USER_QUERY, userA.getId(), userA.getFname(), userA.getLname(), userA.getEmail());
        return userA;
    }

    @Override
    public UserA updatedUser(UserA userA) {
        jdbcTemplate.update(UPDATE_USER_QUERY, userA.getFname(), userA.getId());
        return userA;
    }

    @Override
    public UserA getUserById(int id) {
        return jdbcTemplate.queryForObject(GET_USER_BY_ID_QUERY, (rs, rowNum) -> {
            return new UserA(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        }, id);
    }

    @Override
    public String deletedById(int id) {
        jdbcTemplate.update(DELETED_USER_BY_ID_QUERY, id);
        return "User deleted" + id;
    }

    @Override
    public List<UserA> getAllUsers() {
        return jdbcTemplate.query(GET_ALL_USERS_QUERY, (rs, rowNum) -> {
            return new UserA(rs.getInt("id"), rs.getString("fname"), rs.getString("lname"), rs.getString("email"));
        });
    }
}
