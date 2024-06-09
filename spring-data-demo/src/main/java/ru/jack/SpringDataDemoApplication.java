package ru.jack;

import lombok.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.*;
import org.springframework.dao.*;
import org.springframework.data.relational.core.sql.*;
import org.springframework.jdbc.core.*;

import javax.sql.*;
import java.sql.*;
import java.util.*;

@SpringBootApplication
/**
 * spring-data-jdbc - набор готовых инструментов для взаимодействия с базой данных.
 * По сути, оборачивает стандартный JDBC и предоставляет удобные интерфейсы для настройки и
 * взаимодействия с БД.
 */
public class SpringDataDemoApplication {

	@SneakyThrows
	public static void main(String[] args) {
		SpringApplication.run(SpringDataDemoApplication.class, args);
//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//
//		//JdbcTemplate
//
//		jdbcTemplate.execute("create table users(id bigint, name varchar(512))");
//		jdbcTemplate.execute("insert into users(id, name) values(1, 'Igor')");
//
//		List<User> users = jdbcTemplate.query("select id, name from users", new RowMapper<User>() {
//			@Override
//			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return new User(rs.getLong("id"), rs.getString("name"));
//			}
//		});
//
//		DataSource dataSource = context.getBean(DataSource.class);
//
//		try (Connection connection = dataSource.getConnection()) {
//			try (Statement statement = connection.createStatement()) {
//				statement.execute("create table users(id bigint, name varchar(512))");
//			}
//
//			try (Statement statement = connection.createStatement()) {
//				statement.execute("insert into users(id, name) values(1, 'Igor')");
//			}
//
//			try (Statement statement = connection.createStatement()) {
//				ResultSet resultSet = statement.executeQuery("select id, name from users");
//				while (resultSet.next()) {
//					System.out.println(resultSet.getInt("id"));
//					System.out.println(resultSet.getString("name"));
//				}
//			}
//		}
    }
	@Data
	@AllArgsConstructor
	static class User {
		long id;
		String name;
	}
}
