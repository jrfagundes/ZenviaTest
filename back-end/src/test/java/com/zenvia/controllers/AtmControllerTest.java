package com.zenvia.controllers;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

import com.zenvia.services.AtmService;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;


@WebMvcTest
class AtmControllerTest {
	
	@Autowired
	private AtmController atmController;
	
	@MockBean
	private AtmService atmService;
	
	@BeforeEach
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.atmController);
	}


	@Test
	void deveRetornarSucesso_QuandoExecutarSaque() {
		
		Map<Integer, Integer> numberOfBanknotes = new HashMap<Integer, Integer>();
		numberOfBanknotes.put(10, 0);
		numberOfBanknotes.put(20, 0);
		numberOfBanknotes.put(50, 0);
		numberOfBanknotes.put(100, 0);
		
		try {
			when(this.atmService.withdraw(470)).thenReturn(numberOfBanknotes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RestAssuredMockMvc.given().accept(ContentType.JSON)
		.when()
			.post("/withdraw/{value}", 470)
		.then()
			.statusCode(HttpStatus.OK.value());
	}

}
