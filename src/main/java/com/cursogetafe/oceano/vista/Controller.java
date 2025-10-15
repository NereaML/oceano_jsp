package com.cursogetafe.oceano.vista;

import java.io.IOException;
import java.util.Set;
import java.util.Date;
import java.util.TreeSet;
import java.text.SimpleDateFormat;

import com.cursogetafe.oceano.modelo.Criatura;
import com.cursogetafe.oceano.modelo.Especie;
import com.cursogetafe.oceano.modelo.Habitat;
import com.cursogetafe.oceano.modelo.TipoEspecie;
import com.cursogetafe.oceano.negocio.Oceano;
import com.cursogetafe.oceano.negocio.OceanoImpl;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/oceano/*")
public class Controller extends HttpServlet {
    
    private Oceano negOceano;
    private String home;
    
    @Override
    public void init() throws ServletException{
        negOceano = new OceanoImpl();
        
        ServletContext app = getServletContext();
        
        home = app.getContextPath() + "/oceano";
        
        app.setAttribute("home", home);
        app.setAttribute("css", app.getContextPath() + "/css");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        HttpSession sesion = req.getSession();
        
        if(!sesionIniciada(sesion)) return;

        switch (path) {
            case "/informacion":
                req.setAttribute("origen", "controlador");
                req.getRequestDispatcher("/WEB-INF/informacion").forward(req, resp);        
                break;
                
            case "/menu_principal":
                eliminaDatosSesion(sesion);
                req.getRequestDispatcher("/WEB-INF/vista/menu_principal.jsp").forward(req, resp);
                break;
                
            case "/listado_criaturas":
                req.getRequestDispatcher("/WEB-INF/vista/listado_criaturas.jsp").forward(req, resp);
                break;
                
            case "/alta_criatura":
                try {
                    
                    req.setAttribute("especies", negOceano.getEspecies());
                    req.setAttribute("habitats", negOceano.getHabitats());

                   
                    Set<TipoEspecie> tiposEspecie = new TreeSet<>();
                    for(Especie e : negOceano.getEspecies()) {
                        tiposEspecie.add(e.getTipo());
                    }
                    req.setAttribute("tiposEspecie", tiposEspecie);

                } catch(Exception e) {
                    e.printStackTrace();
                    req.setAttribute("error", "No se pudieron cargar las listas de especies o hábitats");
                }

                req.getRequestDispatcher("/WEB-INF/vista/alta_criatura.jsp").forward(req, resp);
                break;

            case "/cerrar_sesion":    
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getPathInfo();
        HttpSession sesion = req.getSession();
        
        if(!sesionIniciada(sesion)) return;

        switch (path){
            case "/listado_criaturas":
                String nombreComun = req.getParameter("nombreComun"); 
                Set<Criatura> cria = null;
                try {
                    cria = negOceano.getCriaturasPorNombre(nombreComun); 
                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("Error", "Ha ocurrido un problema al cargar las criaturas.");
                }
                req.setAttribute("criaturas", cria);
                req.getRequestDispatcher("/WEB-INF/vista/listado_criaturas.jsp").forward(req, resp);
                break;
                
            case "/alta_criatura":
                try {
                    nombreComun = req.getParameter("nombreComun");
                    String fechaStr = req.getParameter("fechaIngreso");
                    int idEspecie = Integer.parseInt(req.getParameter("idEspecie"));
                    int idHabitat = Integer.parseInt(req.getParameter("idHabitat"));

                    Date fechaIngreso = new SimpleDateFormat("dd-MM-yyyy").parse(fechaStr);

                    Especie especie = negOceano.getEspeciePorId(idEspecie);
                    Habitat habitat = negOceano.getHabitatPorId(idHabitat);

                    Criatura criatura = new Criatura();
                    criatura.setNombreComun(nombreComun);
                    criatura.setFechaIngreso(fechaIngreso);
                    criatura.setEspecies(especie);
                    criatura.setHabitat(habitat);

                    negOceano.guardarCriatura(criatura);

                    req.setAttribute("mensaje", "Criatura creada correctamente");

                } catch(Exception e) {
                    e.printStackTrace();
                    req.setAttribute("error", "No se pudo crear la criatura");
                }

                try {
                    req.setAttribute("especies", negOceano.getEspecies());
                    req.setAttribute("habitats", negOceano.getHabitats());
                    
                    Set<TipoEspecie> tiposEspecie = new TreeSet<>();
                    for(Especie e : negOceano.getEspecies()) {
                        tiposEspecie.add(e.getTipo());
                    }
                    req.setAttribute("tiposEspecie", tiposEspecie);

                } catch(Exception e) {
                    e.printStackTrace();
                    req.setAttribute("error", "No se pudieron cargar las listas de especies o hábitats");
                }

                req.getRequestDispatcher("/WEB-INF/vista/alta_criatura.jsp").forward(req, resp);
                break;
        }
    }

    private boolean sesionIniciada(HttpSession sesion) {
        return true; // TODO: implementar control de sesión
    }

    private void eliminaDatosSesion(HttpSession sesion) {
        // TODO: implementar limpieza de sesión si hace falta
    }
}
