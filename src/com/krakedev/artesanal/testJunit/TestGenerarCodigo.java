package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.NegocioMejorado;

public class TestGenerarCodigo {

    @Test
    public void testFormatoCodigo() {
        NegocioMejorado negocio = new NegocioMejorado();
        String codigo = negocio.generarCodigo();
        
        assertNotNull(codigo, "El código no debe ser nulo");
        assertTrue(codigo.startsWith("M-"), "El código debe empezar con 'M-'");
        
        // Extraemos el número y validamos el rango
        String numeroStr = codigo.substring(2);
        int numero = Integer.parseInt(numeroStr);
        assertTrue(numero >= 1 && numero <= 100, "El número debe estar entre 1 y 100");
    }
}