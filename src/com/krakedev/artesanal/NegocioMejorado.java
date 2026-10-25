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
}