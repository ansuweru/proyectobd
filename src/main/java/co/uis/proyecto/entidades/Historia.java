package co.uis.proyecto.entidades;

import jakarta.persistence.Id;

public class Historia {
    @Id
    private long num_historia;
    private String descripcion;
    private long cedula_usuario;

    public Historia(long num_historia, String descripcion, long cedula_usuario) {
        this.num_historia = num_historia;
        this.descripcion = descripcion;
        this.cedula_usuario = cedula_usuario;
    }

    public long getNum_historia() {
        return num_historia;
    }

    public void setNum_historia(long num_historia) {
        this.num_historia = num_historia;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public long getCedula_usuario() {
        return cedula_usuario;
    }

    public void setCedula_usuario(long cedula_usuario) {
        this.cedula_usuario = cedula_usuario;
    }
}
