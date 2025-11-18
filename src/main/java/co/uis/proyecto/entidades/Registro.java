package co.uis.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Registro {
    @Id
    private long num_registro;
    private String fecha;
    private String hora;
    private long num_historia;
    private long num_usuario;

    public Registro(long num_registro, String fecha, String hora, long num_historia, long num_usuario) {
        this.num_registro = num_registro;
        this.fecha = fecha;
        this.hora = hora;
        this.num_historia = num_historia;
        this.num_usuario = num_usuario;
    }

    public long getNum_registro() {
        return num_registro;
    }

    public void setNum_registro(long num_registro) {
        this.num_registro = num_registro;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public long getNum_historia() {
        return num_historia;
    }

    public void setNum_historia(long num_historia) {
        this.num_historia = num_historia;
    }

    public long getNum_usuario() {
        return num_usuario;
    }

    public void setNum_usuario(long num_usuario) {
        this.num_usuario = num_usuario;
    }
}
