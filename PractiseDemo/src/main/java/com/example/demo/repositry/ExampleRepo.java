package com.example.demo.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.domain.ExampleDemo;

public interface ExampleRepo extends JpaRepository<ExampleDemo, Integer> {

}
