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

@SpringBootApplication
public class SpringDataDemoApplication {

	@SneakyThrows
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);
		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);

		//JdbcTemplate
		
		jdbcTemplate.execute("create table users(id bigint, name varchar(512))");
		jdbcTemplate.execute("insert into users(id, name) values(1, 'Igor')");
		jdbcTemplate.query("select id, name from users", new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return null;
			}
		});

		DataSource dataSource = context.getBean(DataSource.class);

		try (Connection connection = dataSource.getConnection()) {
			try (Statement statement = connection.createStatement()) {
				statement.execute("create table users(id bigint, name varchar(512))");
			}

			try (Statement statement = connection.createStatement()) {
				statement.execute("insert into users(id, name) values(1, 'Igor')");
			}

			try (Statement statement = connection.createStatement()) {
				ResultSet resultSet = statement.executeQuery("select id, name from users");
				while (resultSet.next()) {
					System.out.println(resultSet.getInt("id"));
					System.out.println(resultSet.getString("name"));
				}
			}
		}
    }
	@Data
	static class User {
		long id;
		String name;
	}
}
