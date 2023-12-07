package CVDS.Dina.proyecto.model;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Plato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre_plato", nullable = false)
    private String nombrePlato;

    @Column(nullable = false)
    private double precio;

    private String descripcion;

    public Plato(){
    }

    //getters y setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plato plato)) return false;

        if (Double.compare(plato.getPrecio(), getPrecio()) != 0) return false;
        if (!getId().equals(plato.getId())) return false;
        if (!getNombrePlato().equals(plato.getNombrePlato())) return false;
        return getDescripcion().equals(plato.getDescripcion());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId().hashCode();
        result = 31 * result + getNombrePlato().hashCode();
        temp = Double.doubleToLongBits(getPrecio());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getDescripcion().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Plato{" +
                "id=" + id +
                ", nombrePlato='" + nombrePlato + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
