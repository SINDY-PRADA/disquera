package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.albumDao;
import model.albumVo;


public class albumController extends HttpServlet {
    albumVo r = new albumVo();
    albumDao rd = new albumDao();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Entró al DoGet");
        String accion=req.getParameter("accion");

        switch(accion){
            case "index":
            req.getRequestDispatcher("index.jsp").forward(req, resp);
            break;
            case "añadirAlbum":
                formulario(req,resp);
            break;
            case "consultarAlbum":
                listar(req,resp);
            break;
            case "eliminarAlbum":
                eliminar(req,resp);
            break;
            
            case "estado":
                estado(req,resp);
            break;
                    
            case "editarAlbum":
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
            req.getRequestDispatcher("views/Album/addAlbum.jsp").forward(req, resp);
            System.out.println("Formulario abierto exitosamente");
        }catch(Exception e){
            System.out.println("El formulario no ha sido abierto con éxito"+e.getMessage().toString());
        }
    }

//AGREGAR ÁLBUM
    private void add(HttpServletRequest req, HttpServletResponse resp) {

        if(req.getParameter("nombreAlbum")!=null){
            r.setNombreAlbum(req.getParameter("nombreAlbum"));

        }if (req.getParameter("anioPublicacion")!=null) {
            r.setAnioPublicacion(Integer.parseInt(req.getParameter("anioPublicacion")));   
        }
        if(req.getParameter("estadoALbum")!=null){
            r.setEstadoAlbum(true);
        }
        try {
            rd.add(r);
            System.out.println("El Registro fue insertado correctamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Ocurrió un Error en la inserción del registro "+e.getMessage().toString());
        }
    }

//LISTAR ÁLBUM
        private void listar (HttpServletRequest req, HttpServletResponse resp) {
            try {
                List albumList=rd.listar();
                req.setAttribute("listar", albumList);
                req.getRequestDispatcher("views/Album/listAlbum.jsp").forward(req, resp);
                System.out.println("Datos listados para la edición");
            } catch (Exception e) {
                System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
            } 
        }  


//ELIMINAR ÁLBUM
    private void eliminar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));//Cambiar de string a int
        }
        try {
            rd.eliminar(r.getIdAlbum());;
            System.out.println("Álbum eliminado exitosamente");
            listar(req, resp);
        } catch (Exception e) {
            System.out.println("Ocurrió un Error al eliminar"+e.getMessage().toString());
        }
    }



//MODIFICAR ÁLBUM
    private void actualizar(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        try {
            List albumLists=rd.listarAlbums(r.getIdAlbum());
            req.setAttribute("albumLists", albumLists);
            req.getRequestDispatcher("views/Album/editAlbum.jsp").forward(req, resp);
            System.out.println("Datos listados exitosamente en la edición");

        } catch (Exception e) {
            System.out.println("Ocurrió problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void edit(HttpServletRequest req, HttpServletResponse resp) {
        if(req.getParameter("idAlbum")!=null){
            r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
        }
        if(req.getParameter("nombreAlbum")!=null){
            r.setNombreAlbum(req.getParameter("nombreAlbum"));
        }
        if(req.getParameter("anioPublicacion")!=null){
            r.setAnioPublicacion(Integer.parseInt(req.getParameter("anioPublicacion")));
        }
        if(req.getParameter("estadoAlbum")!=null){
            r.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));
        }
        try {
            rd.actualizar(r);
            System.out.println("Editar el registro del álbum");
            listar(req, resp);

        } catch (Exception e) {
            System.out.println("Ocurrió un Error al editar "+e.getMessage().toString());
        }
    }

//ESTADO ÁLBUM
private void estado(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("idAlbum")!=null){
        r.setIdAlbum(Integer.parseInt(req.getParameter("idAlbum")));
    }
    if(req.getParameter("estadoAlbum")!=null){
        r.setEstadoAlbum(Boolean.parseBoolean(req.getParameter("estadoAlbum")));
    }
    try {
        rd.estado(r.getIdAlbum(), r.getEstadoAlbum());
        System.out.println("Estado cambiado exitosamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Ocurrió un Error en el cambio de estado "+e.getMessage().toString());
    }
}

}

