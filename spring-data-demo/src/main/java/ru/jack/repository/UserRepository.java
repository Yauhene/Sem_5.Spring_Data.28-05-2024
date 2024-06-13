package ru.jack.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.*;
import ru.jack.model.User;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {

// jql
//    @Query("select u from User u where u.name = :name")
//    List<User> myquery(String name); // поиск по name используя @Query("select u from User u where u.name = :nane")
    //
    // Возможно "name" заменять своей переменной-параметром:
    @Query("select u from User u where u.name = :myvalue")
        List<User> myquery(@Param(value = "myvalue") String name);

    @Query(nativeQuery = true, value = "SELECT id, age, name FROM USERS")
    List<Object> myquery2();


    List<User> findAllByName(String name);
    List<User> findByNameAndAge(String name, Integer age);
    List<User> findByNameIgnoreCase(String name);
    List<User> findFirstByName(Pageable pageable, String name);
//    List<User> findByAgeGreaterThen(Pageable pageable, int value);  // ====!!! у меня не пошло
//    Page<User> findByAgeGreaterThen(Pageable pageable, int value); // ====!!! у меня не пошло
//    Page<User> findTop3ByAgeGreaterThan(int value); // ====!!! у меня не пошло
}
