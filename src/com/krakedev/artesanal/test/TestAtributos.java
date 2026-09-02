package com.krakedev.artesanal.test;

import com.krakedev.artesanal.Maquina;

public class TestAtributos {

	public static void main(String[] args) {
		
		Maquina rubia = new Maquina ("CH502","Pilsener", "cerveza rubia", 0.02, 1000);
		rubia.imprimir();
		
		rubia.setNombreCerveza("Golden Ale");
		rubia.setDescripcion("Cerveza con aroma mas intenso");
		
		rubia.imprimir();
		
		Maquina club = new Maquina ("JK503","Club", "cerveza verde", 0.10);
		club.imprimir();
		
		
	}

}
