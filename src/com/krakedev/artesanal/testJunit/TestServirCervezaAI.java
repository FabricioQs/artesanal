package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	
	@Test
    public void testServirCervezaConCantidadSuficiente() {
        // Valida que, si hay suficiente cerveza, se descuente la cantidad y se cobre lo correcto.
        // Se utiliza el constructor de 4 parámetros.
        Maquina maquina = new Maquina("LJD503", "Pilsener", "Cerveza amarga y lupulada", 0.05, 5000.0);
        
        // La máquina empieza en 0. Usamos el método disponible para añadir 1000 ml.
        maquina.recargarCerveza(1000.0);

        // Se intenta servir 400 ml. El valor esperado es 400 * 0.05 = 20.0
        double valorAPagar = maquina.servirCerveza(400.0);

        // Comprobamos el valor a pagar usando una tolerancia de 0.01 para los double
        assertEquals(20.0, valorAPagar, 0.01, "El valor a pagar debe ser el resultado de cantidad * precioPorMl.");
        
        // Comprobamos que la cantidad actual en la máquina se haya restado (1000 - 400 = 600)
        assertEquals(600.0, maquina.getCantidadActual(), 0.01, "La cantidad actual debe disminuir acorde a lo servido.");
    }

    @Test
    public void testServirCervezaSinCantidadSuficiente() {
        // Valida que, si el cliente pide más de lo que hay, no se sirva nada ni se modifique el stock.
        // Se utiliza el constructor de 3 parámetros (asigna 10000 a capacidadMaxima).
        Maquina maquina = new Maquina("LJD503", "Club", "Cerveza negra y robusta", 0.08);
        
        // Usamos llenarMaquina, lo cual deja la cantidadActual en capacidadMaxima - 100 (es decir, 9900 ml)
        maquina.llenarMaquina();

        // Se intenta servir 10000 ml, lo cual supera los 9900 ml disponibles.
        double valorAPagar = maquina.servirCerveza(10000.0);

        // Comprobamos que el método retorne 0 al no tener suficiente cerveza
        assertEquals(0.0, valorAPagar, 0.01, "Si no hay suficiente cerveza, debe retornar 0.");
        
        // Comprobamos que la cantidad actual permanezca intacta en 9900
        assertEquals(9800.0, maquina.getCantidadActual(), 0.01, "La cantidad actual no debe modificarse si no se logra servir.");
    }

    @Test
    public void testServirCervezaCantidadExacta() {
        // Valida el caso límite donde el cliente pide exactamente toda la cerveza que queda en la máquina.
        // Se utiliza el constructor de 4 parámetros.
        Maquina maquina = new Maquina("LJD503", "Pilsner", "Cerveza rubia y ligera", 0.04, 2000.0);
        
        // Añadimos exactamente 500 ml.
        maquina.recargarCerveza(500.0);

        // Se sirve exactamente los 500 ml disponibles (500 * 0.04 = 20.0)
        double valorAPagar = maquina.servirCerveza(500.0);

        // Comprobamos que se retorne el valor correcto a cobrar
        assertEquals(20.0, valorAPagar, 0.01, "Debe cobrar correctamente al servir todo el stock disponible.");
        
        // Comprobamos que la máquina quede completamente vacía
        assertEquals(0.0, maquina.getCantidadActual(), 0.01, "La cantidad actual debe quedar en 0 al servir exactamente lo disponible.");
    }

    @Test
    public void testServirCervezaMaquinaVacia() {
        // Valida el comportamiento de la función desde el estado inicial de la clase.
        // Se utiliza el constructor de 3 parámetros.
        Maquina maquina = new Maquina("HOK503", "Lager", "Cerveza clásica", 0.03);
        
        // No se recarga nada, por lo que cantidadActual es 0 por defecto tras el constructor.
        
        // Se intenta servir 200 ml.
        double valorAPagar = maquina.servirCerveza(200.0);

        // Comprobamos que el método controle correctamente cuando está en 0
        assertEquals(0.0, valorAPagar, 0.01, "Si la máquina está vacía, debe retornar 0.");
        assertEquals(0.0, maquina.getCantidadActual(), 0.01, "La cantidad actual debe seguir siendo 0.");
    }

}
