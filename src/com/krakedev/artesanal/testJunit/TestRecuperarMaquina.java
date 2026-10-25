package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestRecuperarMaquina {

    @Test
    public void testRecuperarExistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        negocio.agregarMaquina("Pilsener", "Rubia", 0.02);
        
        // Obtenemos el código de la máquina recién creada en la posición 0
        Maquina m = negocio.getMaquinas().get(0);
        String codigoGenerado = m.getCodigo();
        
        // Probamos que el método recuperarMaquina la encuentre
        Maquina recuperada = negocio.recuperarMaquina(codigoGenerado);
        
        assertNotNull(recuperada, "La máquina debería existir en la lista");
        assertEquals(codigoGenerado, recuperada.getCodigo(), "Los códigos deben coincidir");
    }
    
    @Test
    public void testRecuperarInexistente() {
        NegocioMejorado negocio = new NegocioMejorado();
        Maquina recuperada = negocio.recuperarMaquina("M-999");
        
        assertNull(recuperada, "Debe retornar null si el código no existe");
    }
}