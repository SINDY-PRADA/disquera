package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class cancionDao {
    //Metodos
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int filas;


//AGREGAR
    public int add(cancionVo cancion) throws SQLException{
        sql="INSERT INTO cancion (nombreCancion, fechaGrabacion, duracionCancion, estadoCancion ) values(?,?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, cancion.getNombreCancion());
            ps.setString(2, cancion.getFechaGrabacion());
            ps.setString(3, cancion.getDuracionCancion());
            ps.setBoolean(4, cancion.getEstadoCancion());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró la canción correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    }


//LISTAR
    public List<cancionVo> listar() throws SQLException{
        List<cancionVo> cancion = new ArrayList<>();
        sql = "SELECT * FROM cancion";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
                
                while (rs.next()) {
                    cancionVo filas = new cancionVo();
                    filas.setIdCancion(rs.getInt("idCancion"));
                    filas.setNombreCancion(rs.getString("nombreCancion"));
                    filas.setFechaGrabacion(rs.getString("fechaGrabacion"));
                    filas.setDuracionCancion(rs.getString("duracionCancion"));
                    filas.setEstadoCancion(rs.getBoolean("estadoCancion"));
                    cancion.add(filas);
                }
                ps.close();
                System.out.println("consulta exitosa");
            } catch (Exception e) {
                System.out.println("La consulta no se pudo ejecutar "+e.getMessage().toString());
            }
            finally{
                con.close();
            }
    
            return cancion;
        }

//ELIMINAR
        public void eliminar(int idCancion) throws SQLException{
            sql="DELETE FROM cancion WHERE idCancion="+idCancion;//variable para el sql
            try{
                con=Conexion.conectar(); //abrir conexión
                ps=con.prepareStatement(sql); //preparar sentencia
                System.out.println(ps);
                ps.executeUpdate(); //Ejecutar sentencia
                ps.close(); //cerrar sentencia
                System.out.println("Se elimino correctamente");
                
            }catch(Exception e){
                System.out.println("Error en la eliminación "+e.getMessage().toString());
            }
    
            finally{
                con.close();//cerrando conexión
            }
        }


//MODIFICAR

public List <cancionVo> Listarcancion(int idCancion) throws SQLException{
    List<cancionVo> cancion=new ArrayList<>();
    sql="SELECT * FROM cancion WHERE idCancion="+idCancion;//variable para la BD
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
            cancionVo filas=new cancionVo();
            //Escribir  en el setter cada valor encontrado
            filas.setIdCancion(rs.getInt("idCancion"));//peticion de id
            filas.setNombreCancion(rs.getString("nombreCancion"));//peticion de nombre
            filas.setFechaGrabacion(rs.getString("fechaGrabacion")); //peticion de fecha 
            filas.setDuracionCancion(rs.getString("duracionCancion")); //peticion de duracion
            filas.setEstadoCancion(rs.getBoolean("estadoCancion"));//peticion de estado
            cancion.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa a cancion por id especificos SELECT * FROM cancion WHERE idCancion="+idCancion);
    } catch (Exception e) {
        System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
    }
    finally{
        con.close();
    }

    return cancion;//retorna array con los datos de la tabla
}


public int actualizar(cancionVo cancion) throws SQLException{
    sql="UPDATE cancion SET nombreCancion=?, fechaGrabacion=?, duracionCancion=?, estadoCancion=? WHERE idCancion=?";

    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.setString(1, cancion.getNombreCancion());
        ps.setString(2, cancion.getFechaGrabacion());
        ps.setString(3, cancion.getDuracionCancion());
        ps.setBoolean(4, cancion.getEstadoCancion());
        ps.setInt(5, cancion.getIdCancion());
        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se edito la cancion correctamente");
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();
    }
    return filas;
    }

    //ESTADO
    public void estado(int idCancion , Boolean estadoCancion) throws SQLException{
        sql="UPDATE cancion SET estadoCancion="+estadoCancion+" WHERE idCancion="+idCancion;//variable para el sql
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoCancion+" correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }

        finally{
            con.close();//cerrando conexión
        }
    }
}
