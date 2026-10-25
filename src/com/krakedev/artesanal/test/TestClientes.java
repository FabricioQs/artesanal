package com.krakedev.artesanal.test;

import com.krakedev.artesanal.NegocioMejorado;

public class TestClientes {
    public static void main(String[] args) {
        NegocioMejorado negocio = new NegocioMejorado();
        
        System.out.println("Intentando registrar cliente...");
        negocio.registrarCliente("Juan Perez", "1712345678");
        System.out.println("Cliente registrado exitosamente.");
    }
}