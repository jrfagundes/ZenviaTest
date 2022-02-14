package com.zenvia.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zenvia.services.AtmService;

@RestController
@RequestMapping("/withdraw")
public class AtmController {
	
	private AtmService atmService;
	
	@Autowired
	public AtmController(AtmService atmService) {
		this.atmService = atmService;
	}
	
	@CrossOrigin(origins = "*")
	@RequestMapping(method = RequestMethod.POST, value = "/{value}")
	public ResponseEntity<?> withdraw(@PathVariable Float value) {
		ResponseEntity<?> response = null;
		Map<Integer, Integer> result;
		try {
			result = atmService.withdraw(value);
			response = new ResponseEntity<Map<Integer, Integer>>(result, null, HttpStatus.OK);
		} catch (Exception e) {
			response = new ResponseEntity<String>(e.getMessage(), null, HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}		
		return response;
	}

}
