package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Boya;
import com.example.demo.services.BoyaService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	BoyaService boyaService;

	@Test
	public void crearBoya(){
		Boya boya = boyaService.crearBoya(21,22);
		assertTrue(boya.getLongitudDeInstalacion() == 22);
		assertTrue(boya.getLatitudDeInstalacion() == 21);
	}
}