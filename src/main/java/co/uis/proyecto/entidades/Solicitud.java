package co.uis.proyecto.entidades;

import jakarta.persistence.Id;

public class Solicitud {
    @Id
    private long num_solicitud;
    private String descripcion;
    private String fecha;
    private long cedula_usuario;

    public Solicitud(long num_solicitud, String descripcion, String fecha, long cedula_usuario) {
        this.num_solicitud = num_solicitud;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.cedula_usuario = cedula_usuario;
    }

    public long getNum_solicitud() {
        return num_solicitud;
    }

    public void setNum_solicitud(long num_solicitud) {
        this.num_solicitud = num_solicitud;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public long getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(long cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }
}
