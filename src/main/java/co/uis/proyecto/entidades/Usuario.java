package co.uis.proyecto.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    private long cedula;
    private String nombre_apellido;
    private String fecha_nacimiento;
    private String nacionalidad;

    public Usuario(long cedula, String nombre_apellido, String fecha_nacimiento, String nacionalidad) {
        this.cedula = cedula;
        this.nombre_apellido = nombre_apellido;
        this.fecha_nacimiento = fecha_nacimiento;
        this.nacionalidad = nacionalidad;
    }
    @OneToMany(mappedBy = "usuario")
    public long getCedula() {
        return cedula;
    }

    public void setCedula(long cedula) {
        this.cedula = cedula;
    }

    public String getNombre_apellido() {
        return nombre_apellido;
    }

    public void setNombre_apellido(String nombre_apellido) {
        this.nombre_apellido = nombre_apellido;
    }

    public String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(String fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }
}
