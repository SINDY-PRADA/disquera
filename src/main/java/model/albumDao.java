package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class albumDao {
    //Metodos
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql = null;
    int filas;


//AGREGAR
    public int add(albumVo album) throws SQLException{
        sql="INSERT INTO album(nombreAlbum, anioPublicacion, estadoAlbum) values(?,?,?)";
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            ps.setString(1, album.getNombreAlbum());
            ps.setInt(2, album.getAnioPublicacion());
            ps.setBoolean(3, album.getEstadoAlbum());
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se registró el album correctamente");
        }catch(Exception e){
            System.out.println("Error en el regisro "+e.getMessage().toString());
        }
        finally{
            con.close();//cerrando conexión
        }
        return filas;
    }


//LISTAR
    public List<albumVo> listar() throws SQLException{
        List<albumVo> album = new ArrayList<>();
        sql = "SELECT * FROM album";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            System.out.println(ps);
            rs = ps.executeQuery(sql);
                
                while (rs.next()) {
                    albumVo filas = new albumVo();
                    filas.setIdAlbum(rs.getInt("idAlbum"));
                    filas.setNombreAlbum(rs.getString("nombreAlbum"));
                    filas.setAnioPublicacion(rs.getInt("anioPublicacion"));
                    filas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));
                    album.add(filas);
                }
                ps.close();
                System.out.println("consulta exitosa");
            } catch (Exception e) {
                System.out.println("La consulta no se pudo ejecutar "+e.getMessage().toString());
            }
            finally{
                con.close();
            }
    
            return album;
        }

//ELIMINAR
        public void eliminar(int idAlbum) throws SQLException{
            sql="DELETE FROM album WHERE idAlbum="+idAlbum;//variable para el sql
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

public List <albumVo> listarAlbums(int idAlbum) throws SQLException{
    List<albumVo> album=new ArrayList<>();
    sql="SELECT * FROM album WHERE idAlbum="+idAlbum;//variable para la BD
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
            albumVo filas=new albumVo();
            //Escribir  en el setter cada valor encontrado
            filas.setIdAlbum(rs.getInt("idAlbum"));//peticion de id
            filas.setNombreAlbum(rs.getString("nombreAlbum"));//peticion de nombre
            filas.setAnioPublicacion(rs.getInt("anioPublicacion"));//peticion del año
            filas.setEstadoAlbum(rs.getBoolean("estadoAlbum"));//peticion de estado
            album.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa a album por id especificos SELECT * FROM album WHERE idAlbum="+idAlbum);
    } catch (Exception e) {
        System.out.println("La consulta no pudo ser ejecutado "+e.getMessage().toString());//Error
    }
    finally{
        con.close();
    }

    return album;//retorna array con los datos de la tabla
}


public int actualizar(albumVo album) throws SQLException{
    sql="UPDATE album SET nombreAlbum=?,anioPublicacion=?, estadoAlbum=? WHERE idAlbum=?";

    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        System.out.println(ps);
        ps.setString(1, album.getNombreAlbum());
        ps.setInt(2, album.getAnioPublicacion());
        ps.setBoolean(3, album.getEstadoAlbum());
        ps.setInt(4, album.getIdAlbum());

        System.out.println(ps);
        ps.executeUpdate();
        ps.close();
        System.out.println("Se edito el album correctamente");

        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();
    }
    return filas;
    }

    //ESTADO
    public void estado(int idAlbum, Boolean estadoAlbum) throws SQLException{
        sql="UPDATE album SET estadoAlbum="+estadoAlbum+" WHERE idAlbum="+idAlbum;//variable para el sql
        try{
            con=Conexion.conectar(); //abrir conexión
            ps=con.prepareStatement(sql); //preparar sentencia
            System.out.println(ps);
            ps.executeUpdate(); //Ejecutar sentencia
            ps.close(); //cerrar sentencia
            System.out.println("Se cambio el estado a "+estadoAlbum+" correctamente");
            
        }catch(Exception e){
            System.out.println("Error en el cambio de estado "+e.getMessage().toString());
        }

        finally{
            con.close();//cerrando conexión
        }
    }
}
