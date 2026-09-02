package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Negocio;

public class TestAsiganarCodigoCliente {

	@Test
	public void asignarCodigo () {
		
		Negocio barDeMoe = new Negocio();
		
		Cliente mario = new Cliente ("Mario", "1736985346");
		Cliente andres = new Cliente ("Andres", "1728653546");
		
		barDeMoe.asignarCodigoCliente(mario);
		barDeMoe.asignarCodigoCliente(andres);
		
		assertEquals(100, mario.getCodigo());
		assertEquals(101, andres.getCodigo());
		
	}
}
