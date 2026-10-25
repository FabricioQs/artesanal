package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.NegocioMejorado;

public class TestValidarDuplicado {

    @Test
    public void testAgregarSinDuplicado() {
        NegocioMejorado negocio = new NegocioMejorado();
        // La primera máquina que agreguemos siempre debería devolver true porque la lista está vacía
        boolean resultado = negocio.agregarMaquina("Club", "Verde", 0.05);
        assertTrue(resultado, "Debería retornar true al agregar la primera máquina");
    }

    @Test
    public void testAgregarConDuplicadoForzado() {
        NegocioMejorado negocio = new NegocioMejorado();
        boolean huboDuplicado = false;
        
        // Intentamos agregar 150 máquinas. Como los códigos van del 1 al 100,
        // garantizamos que en algún momento se generará un código repetido.
        for (int i = 0; i < 150; i++) {
            boolean agregado = negocio.agregarMaquina("Cerveza " + i, "Desc " + i, 0.03);
            if (!agregado) {
                huboDuplicado = true; // Capturamos el momento en que retorna false
                break; // Salimos del ciclo porque ya probamos lo que queríamos
            }
        }
        
        assertFalse(!huboDuplicado, "Debería retornar false al menos una vez al forzar más de 100 inserciones");
    }
}