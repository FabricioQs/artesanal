package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestLlenar {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina ("HCK681","pilsener", "Cerveza fria", 0.02, 8000);
		rubia.imprimir();
		
		rubia.llenarMaquina();
		rubia.imprimir();
		
		Maquina negra = new Maquina("KLS506","Club", "Cerveza buena", 0.03);
		
		negra.imprimir();
		
		negra.llenarMaquina();
		negra.imprimir();

	}

}
