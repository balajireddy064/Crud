package com.example.demo.domain;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Snipe_Demo")
@Setter
@Getter
public class ExampleDemo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int sno;
	private String first_name;
	private String last_name;
	private String email;
	private String password;
	private String conform_password;

}
