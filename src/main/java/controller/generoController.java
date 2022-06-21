package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.generoDao;
import model.generoVo;


public class generoController extends HttpServlet {
    
    generoVo r = new generoVo();
    generoDao rd = new generoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entraste al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            break;
            case "añadirGenero":
                formulario(req,resp);
            break;
            case "editarGenero":
                actualizar(req,resp);
            break;      
            case "consultarGenero":
                listar(req,resp);
            break;
            case "estado":
            estado(req,resp);
            break;
            
            case "eliminarGenero":
            eliminar(req,resp);
            break;
                    
        }
         
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String a=req.getParameter("accion");

        switch(a){
            case "add":
                add(req,resp);
            break;
            
            case "actualizar":
            edit(req, resp);
        break;
    }
}


       private void formulario(HttpServletRequest req, HttpServletResponse resp) {
        try{
            req.getRequestDispatcher("views/Genero/addGenero.jsp").forward(req, resp);
            System.out.println("Formulario abierto exitosamente");
        }catch(Exception e){
            System.out.println("El formulario no ha sido abierto con éxito"+e.getMessage().toString());
        }
    }

//AGREGAR GÉNERO
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreGenero")!=null){
            r.setNombreGenero(req.getParameter("nombreGenero"));
        }
        if(req.getParameter("estadoGenero")!=null){
            r.setEstadoGenero(true);
        }
        try {
            rd.add(r);
            System.out.println("El Registro fue insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Ocurrió un Error en la inserción del registro "+e.getMessage().toString());
        }
    }


//MODIFICAR GÉNERO
private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idGenero")!=null){
        r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
    }
    try {
        List generosLists=rd.Listargenero(r.getIdGenero());
        req.setAttribute("generosLists", generosLists);
        req.getRequestDispatcher("views/Genero/editGenero.jsp").forward(req, resp);
        System.out.println("Datos listados para la edicion");
        for (Object object : generosLists) {
            for (Object sindy : generosLists) {
                System.out.println("Datos listados para la edición"+sindy);
            }
        }
        
    } catch (Exception e) {
        System.out.println("Ocurrió problemas al listar los datos "+e.getMessage().toString());
    }
}

private void edit(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idGenero")!=null){
        r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));//Cambiar de string a int
    }
    if(req.getParameter("nombreGenero")!=null){
        r.setNombreGenero(req.getParameter("nombreGenero"));
    }
    if(req.getParameter("estadoGenero")!=null){
        r.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
        
    }
    try {
        rd.actualizar(r);
        System.out.println("Editar el registro de género");
        listar(req, resp);

    } catch (Exception e) {
        System.out.println("Ocurrió un Error al editar "+e.getMessage().toString());
    }
}

//LISTAR GÉNERO
        private void listar (HttpServletRequest req, HttpServletResponse resp) {
            try {
                List generoList=rd.listar();
                req.setAttribute("listar", generoList);
                req.getRequestDispatcher("views/Genero/listGenero.jsp").forward(req, resp);
                System.out.println("Datos listados exitosamente"+generoList);
            } catch (Exception e) {
                System.out.println("Ocurrió problemas al listar los datos ingresados "+e.getMessage().toString());
            } 
        }  

//ESTADO GÉNERO
private void estado(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idGenero")!=null){
        r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
    }
    if(req.getParameter("estadoGenero")!=null){
        r.setEstadoGenero(Boolean.parseBoolean(req.getParameter("estadoGenero")));
    }
    try {
        rd.estado(r.getIdGenero(), r.getEstadoGenero());
        System.out.println("Estado cambiado exitosamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Ocurrió un Error en el cambio de estado "+e.getMessage().toString());
    }
}

//ELIMINAR GÉNERO
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idGenero")!=null){
            r.setIdGenero(Integer.parseInt(req.getParameter("idGenero")));
        }
        try {
            rd.eliminar(r.getIdGenero());;
            System.out.println("Género eliminado exitosamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Ocurrió un Error al eliminar"+e.getMessage().toString());
        }
    }
}

