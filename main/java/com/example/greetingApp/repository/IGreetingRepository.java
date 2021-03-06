package com.example.greetingApp.repository;

import com.example.greetingApp.model.Greeting;
import com.example.greetingApp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting,Long> {

}
