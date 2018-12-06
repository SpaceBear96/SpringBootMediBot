package com.medibot.spring.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "alumno")
public class Hospitales implements java.io.Serializable{
        @Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private long id;
        @Column(name = "nombre", length = 250)
	private String nombre;
        @Column(name = "c_distrito", length = 250)
	private String distrito;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public Hospitales(long id, String nombre, String distrito) {
        this.id = id;
        this.nombre = nombre;
        this.distrito = distrito;
    }

    public Hospitales() {
    }

    @Override
    public String toString() {
        return "Hospitales{" + "id=" + id + ", nombre=" + nombre + ", distrito=" + distrito + '}';
    }
	
    
}
