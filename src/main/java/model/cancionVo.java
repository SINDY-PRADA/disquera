package model;


public class cancionVo {
    
    private int idCancion;
    private String nombreCancion;
    private String fechaGrabacion;
    private String duracionCancion;
    private boolean estadoCancion;

    public cancionVo(){

    }
    public cancionVo(int idCancion, String nombreCancion, String fechaGrabacion, String duracionCancion, boolean estadoCancion){

        this.idCancion = idCancion;
        this.nombreCancion = nombreCancion;
        this.fechaGrabacion = fechaGrabacion;
        this.duracionCancion = duracionCancion;
        this.estadoCancion = estadoCancion;
    }

    // ID
    public int getIdCancion() {
        return idCancion;
    }
    public void setIdCancion(int idCancion) {
        this.idCancion = idCancion;
    }

    //NOMBRE
    public String getNombreCancion() {
        return nombreCancion;
    }
    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    //FECHA
    public String getFechaGrabacion() {
        return fechaGrabacion;
    }
    public void setFechaGrabacion(String fechaGrabacion) {
        this.fechaGrabacion = fechaGrabacion;
    }

    //DURACION
    public String getDuracionCancion() {
        return duracionCancion;
    }
    public void setDuracionCancion(String duracionCancion) {
        this.duracionCancion = duracionCancion;
    }

    //ESTADO
    public boolean getEstadoCancion() {
        return estadoCancion;
    }
    public void setEstadoCancion(boolean estadoCancion) {
        this.estadoCancion = estadoCancion;
    }
    
}
