package com.krakedev.artesanal.testJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.NegocioMejorado;

public class TestConsumo {
    
    @Test
    public void testConsumoYValorVendido() {
        NegocioMejorado negocio = new NegocioMejorado();
        
        // 1. Preparar máquina
        negocio.agregarMaquina("IPA", "Fuerte", 0.05); 
        Maquina maquina = negocio.getMaquinas().get(0);
        String codMaquina = maquina.getCodigo();
        maquina.llenarMaquina(); // Llena hasta capacidadMaxima - 100
        double capacidadInicial = maquina.getCantidadActual();
        
        // 2. Preparar cliente
        negocio.registrarCliente("Kevin Quishpe", "1711111111"); 
        Cliente cliente1 = negocio.buscarClientePorCedula("1711111111");
        
        // 3. Consumir (100 ml * 0.05 precio = $5.0)
        negocio.consumirCerveza(cliente1.getCodigo(), codMaquina, 100);
        
        // 4. Validar máquina afectada
        assertEquals(capacidadInicial - 100, maquina.getCantidadActual(), 0.01, "La máquina debe descontar 100 ml");
        
        // 5. Validar cliente actualizado
        assertEquals(5.0, cliente1.getTotalConsumido(), 0.01, "El cliente debe acumular $5.0");
        
        // 6. Registrar segundo cliente y consumo (200 ml * 0.05 = $10.0)
        negocio.registrarCliente("David Benitez", "1722222222"); 
        Cliente cliente2 = negocio.buscarClientePorCedula("1722222222");
        negocio.consumirCerveza(cliente2.getCodigo(), codMaquina, 200);
        
        // 7. Validar valor vendido total ($5.0 de Kevin + $10.0 de David = $15.0)
        assertEquals(15.0, negocio.consultarValorVendido(), 0.01, "El negocio debe registrar $15.0 en ventas totales");
    }
}