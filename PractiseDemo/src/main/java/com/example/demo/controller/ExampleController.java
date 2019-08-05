package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.ExampleDemo;
import com.example.demo.service.ExampleService;

@RestController
@RequestMapping("mmp")
public class ExampleController {
	@Autowired
	ExampleService service;

	@PostMapping("/insert")
	public ResponseEntity<Map<String, Object>> demo(@RequestBody ExampleDemo demo) {
		return service.insert(demo);
	}

	@GetMapping("/get")
	public List<ExampleDemo> getall() {
		return service.getall();
	}

	
	
	@PostMapping("/update/{sno}")
	public ResponseEntity<Map<String, Object>> update(@RequestBody ExampleDemo demo, @PathVariable("sno") int sno) {
		return service.update(demo, sno);
	}

	
	
	@DeleteMapping("/delete/{sno}")
	public void delete(@PathVariable("sno") int sno) {
		System.out.println("===in controller class");
		service.delete(sno);
	
	}
	
	
}
