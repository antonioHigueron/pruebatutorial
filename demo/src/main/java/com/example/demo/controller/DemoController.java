package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping(path = "/demo")
	public String getDemo() {
		return "Buenas";
	}
	
	@GetMapping(path = "/{demoId}")
	public ResponseEntity<DemoEntity> getDemo(@PathVariable(name = "demoId") Integer id) {
		System.out.print("cambio");
		System.out.print("cambio_2");
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
