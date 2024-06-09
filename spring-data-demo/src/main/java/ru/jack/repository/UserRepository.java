package ru.jack.repository;

import org.springframework.boot.autoconfigure.data.web.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.yaml.snakeyaml.events.*;
import ru.jack.model.User;
import org.springframework.data.domain.Pageable;

import java.awt.print.*;
import java.util.*;

public interface UserRepository extends JpaRepository<User, Long>, PagingAndSortingRepository<User, Long> {
    List<User> findAllByName(String name);
    List<User> findByNameAndAge(String name, Integer age);
    List<User> findByNameIgnoreCase(String name);
    List<User> findByAgeGreaterThen(Pageable pageable, int value);

//    boolean findFirstByAgeGreaterThen(org.springframework.data.domain.Pageable pageable, int value);
}