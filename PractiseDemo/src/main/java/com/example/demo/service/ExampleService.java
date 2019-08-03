package com.example.demo.service;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.customeException.ExampleCustumException;
import com.example.demo.domain.ExampleDemo;
import com.example.demo.repositry.ExampleRepo;

@Service
public class ExampleService {

	@Autowired
	ExampleRepo repo;

	public ResponseEntity<Map<String, Object>> insert(ExampleDemo demo) {

		try {
			ExampleDemo demo1 = repo.save(demo);
			Map<String, Object> set = new HashMap<String, Object>();
			set.put("Data is Inserted", demo1);
			return ResponseEntity.ok(set);
		} catch (Exception e) {
			return ResponseEntity.ok().build();
		}
	}

	public List<ExampleDemo> getall() {
		return repo.findAll();
	}

	public ExampleDemo findone(int sno) throws Exception {

		if (repo.findById(sno) == null) {
			throw new ExampleCustumException("not able find");
		}
		return repo.findById(sno).get();
	}

	public ResponseEntity<Map<String, Object>> update(ExampleDemo d, int sno) {

		try {
			ExampleDemo demo = repo.findById(sno).get();
			demo.setFirst_name(d.getFirst_name());
			demo.setLast_name(d.getLast_name());
			ExampleDemo de = repo.saveAndFlush(demo);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("raw update", de);// demo.getSno();
			return ResponseEntity.ok(map);

		} catch (Exception e) {
			return ResponseEntity.ok().build();
		}
	}

	public void delete(int sno) {
		repo.deleteById(sno);
	}
}
