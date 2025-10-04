package com.cursogetafe.oceano.test;

import java.util.Date;
import java.util.List;

import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.modelo.Especie;
import com.cursogetafe.oceano.modelo.Habitat;
import com.cursogetafe.oceano.persistencia.OceanoDaoImpl;

public class Test {

    public static void main(String[] args) {

        try {
            OceanoDaoImpl dao = new OceanoDaoImpl();

            Especie especie = new Especie();
            especie.setIdEspecie(1); 

            Habitat habitat = new Habitat();
            habitat.setIdHabitat(1);

            // ----------------------------
            //  Insertar Criatura
            // ----------------------------
            Criatura c1 = new Criatura();
            c1.setNombreComun("Delfín");
            c1.setEspecies(especie);
            c1.setHabitat(habitat);
            c1.setFechaIngreso(new Date());

            dao.insertar(c1);
            System.out.println("Criatura insertada: " + c1.getNombreComun());

            // ----------------------------
            //  Listar todas las criaturas
            // ----------------------------
            List<Criatura> lista = dao.listarTodas();
            System.out.println("Lista de criaturas:");
            for (Criatura c : lista) {
                System.out.println(c.getIdCriatura() + " - " + c.getNombreComun() + " - " + c.getEspecies().getIdEspecie() + " - " + c.getHabitat().getIdHabitat());
            }

            // ----------------------------
            //  Buscar por ID
            // ----------------------------
            Criatura buscada = dao.buscarPorId(c1.getIdCriatura());
            System.out.println("Criatura buscada: " + buscada.getNombreComun());

            // ----------------------------
            //  Actualizar
            // ----------------------------
            buscada.setNombreComun("Delfín Actualizado");
            dao.actualizar(buscada);
            System.out.println("Criatura actualizada: " + buscada.getIdCriatura() + " - " + buscada.getNombreComun());

            // ----------------------------
            //  Eliminar
            // ----------------------------
            dao.eliminar(buscada.getIdCriatura());
            System.out.println("Criatura eliminada: " + buscada.getNombreComun());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
