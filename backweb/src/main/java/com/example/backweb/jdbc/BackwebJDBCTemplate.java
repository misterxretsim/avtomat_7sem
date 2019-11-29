package com.example.backweb.jdbc;

import com.example.backweb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BackwebJDBCTemplate implements BackwebDAO {

    @Autowired
    DataSource dataSource;
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public List<Book> getBooks() {

        return jdbcTemplate.query("select * from book", ((resultSet, i) -> {
            int id = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String date = resultSet.getString("date");
            String title = resultSet.getString("title");
            String body = resultSet.getString("body");
            return new Book(id, author, date, title, body);

        }));
    }

    @Override
    public List<Book> delete(int id) {
        final String sql = "delete from book where id=:id";
        Map<String,Integer> map=new HashMap<String,Integer>();
        map.put("id", id);
        jdbcTemplate.execute(sql,map,new PreparedStatementCallback<Object>() {
            @Override
            public Object doInPreparedStatement(PreparedStatement ps)
                    throws SQLException, DataAccessException {
                return ps.executeUpdate();
            }
        });


        return jdbcTemplate.query("select * from book", ((resultSet, i) -> {
            int ids = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String date = resultSet.getString("date");
            String title = resultSet.getString("title");
            String body = resultSet.getString("body");
            return new Book(ids, author, date, title, body);

        }));
    }

    @Override
    public List<Book> add(Book book) {
        final String sql = "insert into book(author, date, title, body) values(:author,:date,:title,:body)";
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("author", book.getAuthor())
                .addValue("date", book.getDate())
                .addValue("title", book.getTitle())
                .addValue("body", book.getBody());
        jdbcTemplate.update(sql,param, holder);

        return jdbcTemplate.query("select * from book", ((resultSet, i) -> {
            int ids = resultSet.getInt("id");
            String author = resultSet.getString("author");
            String date = resultSet.getString("date");
            String title = resultSet.getString("title");
            String body = resultSet.getString("body");
            return new Book(ids, author, date, title, body);

        }));
    }
}
