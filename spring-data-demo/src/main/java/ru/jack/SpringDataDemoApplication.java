package ru.jack;

import lombok.*;
import org.hibernate.query.*;
import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.*;
import org.springframework.boot.autoconfigure.data.web.*;
import org.springframework.context.*;
import org.springframework.dao.*;
//import org.springframework.data.relational.core.sql.*;
import org.springframework.data.domain.*;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.*;
import ru.jack.model.*;
import ru.jack.repository.*;
import org.springframework.boot.autoconfigure.data.web.*;

import javax.sql.*;
import java.sql.*;
import java.util.*;

import static org.springframework.data.domain.Pageable.*;


@SpringBootApplication
/**
 * spring-data-jdbc - набор готовых инструментов для взаимодействия с базой данных.
 * По сути, оборачивает стандартный JDBC и предоставляет удобные интерфейсы для настройки и
 * взаимодействия с БД.
 */

/**
*JDBC JPA
 *
 * JDBC - библиотека внутри Java для работы с базами данных
 *Driver, Connection, Statement - основные интерфейсы JDBC
 *
 * JPA (Jakarta Persistence API)- набор соглашений по работе с реляционными моделями.
 * Основнаяя идея - "замапить" DB-модель и работать со строками таблиц как с объектами.
 *JPA - это не реализация, а протокол (api, спецификация).
 * Hibernate - одна из реализаций JPA.
 *
 * spring-data-jdbc - набор готовых инструментов для взаимодействия с базой данных.
 * По сути, оборачивает стандартный JDBC и представляет удобные интерфейсы для настройки и взаимодействия с БД.
 *
 * spring-data-jpa - набор готовых инструментов для работы с JPA.
 *
**/
public class SpringDataDemoApplication {

	@SneakyThrows
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataDemoApplication.class, args);
		UserRepository userRepository = context.getBean(UserRepository.class);

		for (int i = 15; i<=25; i++) {
			User user = new User();
			user.setId((long) i);
			user.setName("User #" + i);
			user.setAge(i);
			userRepository.save(user);
			System.out.println(user);
		}

		System.out.println(userRepository.myquery("User #18"));
		System.out.println("result: -----");
		List<Object> objects = userRepository.myquery2();
		System.out.println(objects);

		// Подключение функций из БД:
//		JdbcTemplate jdbcTemplate = context.getBean(JdbcTemplate.class);
//		jdbcTemplate.execute(statement -> {

//		});

//		System.out.println(userRepository.findByAgeGreaterThen(Pageable.ofSize(3), 20)); // ====!!! у меня не пошло


		PageRequest request = PageRequest.of(2,2, Sort.Direction.DESC, "id");
		System.out.println("after request: =======================" + request);
//		Page<User> findAll(Pageable pageable);
		System.out.println(userRepository.findAllByName("User #22"));
//		Page<User> page = userRepository.findByAgeGreaterThen(request, 20); // ====!!! у меня не пошло
//		System.out.println(page.getContent()); // ====!!! у меня не пошло
//		System.out.println(page.getTotalPages()); // ====!!! у меня не пошло
//		System.out.println(page.getTotalElements()); // ====!!! у меня не пошло
//		System.out.println(page.getNumber());
//		System.out.println(userRepository.findTop3ByAgeGreaterThan(20)); // ====!!! у меня не пошло

//		Optional<User> foundUser = userRepository.findById(1L); // ====!!! у меня не пошло
//		foundUser.ifPresent(it -> System.out.println(it));
//
//		userRepository.findById(2L)
//				.ifPresentOrElse(it -> System.out.println(it), () -> System.out.println("Не найден пользователь с идентификатором 2"));
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
//	@Data
//	@AllArgsConstructor
//	static class User {
//		long id;
//		String name;
// 	}
}
