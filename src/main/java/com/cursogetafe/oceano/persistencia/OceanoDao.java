package com.cursogetafe.oceano.persistencia;

import java.util.List;

import com.cursogetafe.oceano.modelo.Criatura;


public interface OceanoDao {


    void insertar(Criatura criatura) throws Exception;
    
    Criatura buscarPorId(int id) throws Exception;
    
    List<Criatura> listarTodas() throws Exception;
    
    void actualizar(Criatura criatura) throws Exception;
    
    void eliminar(int id) throws Exception;
}

