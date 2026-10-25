package com.krakedev.artesanal;

import java.util.ArrayList;


public class NegocioMejorado {
	
	private int ultimoCodigoCliente = 1;
    
    // 1. Agregar atributo maquinas
    private ArrayList<Maquina> maquinas;
    
    // 2. Inicializar el ArrayList en el constructor
    public NegocioMejorado() {
        maquinas = new ArrayList<Maquina>();
    }

    // 1. Getters y Setters
    public ArrayList<Maquina> getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(ArrayList<Maquina> maquinas) {
        this.maquinas = maquinas;
    }
    
 // 3. Método generarCodigo
    public String generarCodigo() {
        // Genera un número aleatorio entre 1 y 100
        int numeroAleatorio = (int) (Math.random() * 100) + 1;
        return "M-" + numeroAleatorio;
    }
    
 // 7. Validación de duplicados en agregarMaquina
    public boolean agregarMaquina(String nombreCerveza, String descripcion, double precioPorMl) {
        String codigo = generarCodigo();
        
        // Validamos si ya existe una máquina con el código generado
        Maquina existente = recuperarMaquina(codigo);
        
        if (existente == null) {
            // No existe, entonces la agregamos
            Maquina nuevaMaquina = new Maquina(codigo, nombreCerveza, descripcion, precioPorMl);
            maquinas.add(nuevaMaquina);
            return true; // agregado
        } else {
            // Ya existe, no se agrega
            return false; // duplicado
        }
    }

    // 5. Método cargarMaquinas
    public void cargarMaquinas() {
        for (int i = 0; i < maquinas.size(); i++) {
            maquinas.get(i).llenarMaquina();
        }
    }

    // 6. Método recuperarMaquina
    public Maquina recuperarMaquina(String codigo) {
        for (int i = 0; i < maquinas.size(); i++) {
            if (maquinas.get(i).getCodigo().equals(codigo)) {
                return maquinas.get(i);
            }
        }
        return null;
    }
    
    // 1. Inicializar la lista para evitar el NullPointerException
    private ArrayList<Cliente> clientes = new ArrayList<>();

    // Getters y setters para clientes
    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    
    
    
    // Agrega esto junto a tus otros atributos al inicio de la clase NegocioMejorado:
    // private int ultimoCodigoCliente = 1;

    // 9. Método registrarCliente
    public void registrarCliente(String nombre, String cedula) {
        Cliente nuevoCliente = new Cliente(nombre, cedula);
        nuevoCliente.setCodigo(ultimoCodigoCliente);
        ultimoCodigoCliente++;
        
        // Aquí es donde va a explotar porque 'clientes' es null
        clientes.add(nuevoCliente);
    }
    
    // 13. Método buscarClientePorCedula
    public Cliente buscarClientePorCedula(String cedula) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getCedula().equals(cedula)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    // 14. Método buscarClientePorCodigo
    public Cliente buscarClientePorCodigo(int codigo) {
        for (int i = 0; i < clientes.size(); i++) {
            // Como el código es int, usamos == en lugar de .equals()
            if (clientes.get(i).getCodigo() == codigo) {
                return clientes.get(i);
            }
        }
        return null;
    }
    
 // 16. Método registrarConsumo (Acumula el valor en el cliente)
    public void registrarConsumo(Cliente cliente, double valor) {
        double acumulado = cliente.getTotalConsumido() + valor;
        cliente.setTotalConsumido(acumulado);
    }

    // 15, 17. Método consumirCerveza (Busca, sirve e integra con registrarConsumo)
    public void consumirCerveza(int codigoCliente, String codigoMaquina, double cantidad) {
        Maquina maquina = recuperarMaquina(codigoMaquina);
        Cliente cliente = buscarClientePorCodigo(codigoCliente);
        
        // Validamos que ambos existan para evitar errores
        if (maquina != null && cliente != null) {
            double valorAPagar = maquina.servirCerveza(cantidad);
            registrarConsumo(cliente, valorAPagar);
        }
    }

    // 19. Método consultarValorVendido (Suma los consumos de todos los clientes)
    public double consultarValorVendido() {
        double totalVendido = 0;
        for (int i = 0; i < clientes.size(); i++) {
            totalVendido += clientes.get(i).getTotalConsumido();
        }
        return totalVendido;
    }
}