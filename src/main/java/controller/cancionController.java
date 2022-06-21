package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.cancionDao;
import model.cancionVo;




public class cancionController extends HttpServlet {
    
    cancionVo r = new cancionVo();
    cancionDao rd = new cancionDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("estas en el DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            break;
            case "añadirCancion":
                formulario(req,resp);
            break;
            case "consultarCancion":
                listar(req,resp);
            break;
            case "eliminarCancion":
                eliminar(req,resp);
            break;
            
            case "estado":
                estado(req,resp);
            break;
                    
            case "editarCancion":
                actualizar(req,resp);
        break;
        }
         
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoPost");
        String accion=req.getParameter("accion");

        switch(accion){
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
            req.getRequestDispatcher("views/Cancion/addCancion.jsp").forward(req, resp);
            System.out.println("Formulario abierto exitosamente");
        }catch(Exception e){
            System.out.println("El formulario no ha sido abierto con éxito"+e.getMessage().toString());
        }
    }

//AGREGAR CANCIÓN
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreCancion")!=null){
            r.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            r.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            r.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            r.setEstadoCancion(true);
        }
        try {
            rd.add(r);
            System.out.println("El Registro fue insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Ocurrió un Error en la inserción del registro "+e.getMessage().toString());
        }
    }

//LISTAR CANCIÓN
        private void listar (HttpServletRequest req, HttpServletResponse resp) {
            try {
                List cancionList=rd.listar();
                req.setAttribute("listar", cancionList);
                req.getRequestDispatcher("views/Cancion/listCancion.jsp").forward(req, resp);
                System.out.println("Datos listados exitosamente");
            } catch (Exception e) {
                System.out.println("Ocurrió problemas al listar los datos ingresados "+e.getMessage().toString());
            } 
        }  


//ELIMINAR CANCIÓN
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            rd.eliminar(r.getIdCancion());;
            System.out.println("Canción eliminada exitosamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Ocurrió un Error al eliminar"+e.getMessage().toString());
        }
    }



//MODIFICAR CANCIÓN
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        try {
            List cancionLists=rd.Listarcancion(r.getIdCancion());
            req.setAttribute("cancionLists", cancionLists);
            req.getRequestDispatcher("views/Cancion/editCancion.jsp").forward(req, resp);
            System.out.println("Datos listados para la edición");
            
        } catch (Exception e) {
            System.out.println("Ocurrió problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idCancion")!=null){
            r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
        }
        if(req.getParameter("nombreCancion")!=null){
            r.setNombreCancion(req.getParameter("nombreCancion"));
        }
        if(req.getParameter("fechaGrabacion")!=null){
            r.setFechaGrabacion(req.getParameter("fechaGrabacion"));
        }
        if(req.getParameter("duracionCancion")!=null){
            r.setDuracionCancion(req.getParameter("duracionCancion"));
        }
        if(req.getParameter("estadoCancion")!=null){
            r.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro de canción");
            listar(req, resp);

        } catch (Exception e) {
            System.out.println("Ocurrió un Error al editar "+e.getMessage().toString());
        }
    }

//ESTADO CANCIÓN
private void estado(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idCancion")!=null){
        r.setIdCancion(Integer.parseInt(req.getParameter("idCancion")));
    }
    if(req.getParameter("estadoCancion")!=null){
        r.setEstadoCancion(Boolean.parseBoolean(req.getParameter("estadoCancion")));
    }
    try {
        rd.estado(r.getIdCancion(), r.getEstadoCancion());
        System.out.println("Estado cambiado exitosamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Ocurrió un Error en el cambio de estado "+e.getMessage().toString());
    }
}

}

