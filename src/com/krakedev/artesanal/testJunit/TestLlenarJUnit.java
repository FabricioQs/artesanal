package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestLlenarJUnit {
	
	@Test
	public void testLllenarMaquina() {
		
		Maquina rubia = new Maquina("LJD503", "Pilsener", "Cerveza", 0.02, 8000);
		
		rubia.llenarMaquina();
		
		assertEquals(7800, rubia.getCantidadActual(), 0.0001);
		
		
	}

}
