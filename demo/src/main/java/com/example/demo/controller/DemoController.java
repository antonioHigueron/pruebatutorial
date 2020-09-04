package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemoEntity;
import com.example.demo.repository.DemoRepository;

@RestController
@RequestMapping("/demo")
public class DemoController {

	@Autowired
	private DemoRepository demoRepository;
	
	@GetMapping(path = "/demo")
	public String getDemo() {
	
		return "Buenas";
	}
	
	@GetMapping(path = "/{demoId}")
	public ResponseEntity<DemoEntity> getDemo(@PathVariable(name = "demoId") Integer id) {
		System.out.print("cambio");
		ResponseEntity<DemoEntity> response = null;
		
		Optional<DemoEntity> demoEntity = demoRepository.findById(id);
		
		if(demoEntity.isPresent()) {
			response = new ResponseEntity<DemoEntity>(demoEntity.get(),HttpStatus.OK);
		}else {
			response = new ResponseEntity<DemoEntity>(demoEntity.get(),HttpStatus.NOT_FOUND);
		}
		
		return response;
	}
	
}
