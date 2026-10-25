package com.krakedev.artesanal;

import java.util.ArrayList;

public class NegocioMejorado {
    
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
}