package Persona;

import java.util.Objects;

public class Persona implements Comparable {
    private Integer dni;
    private String nombre;
    private int edad;

    public Persona(Integer dni,String nombre,int edad){
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String toString(){
        return "Persona: "+getNombre() +" dni:"+getDni()+" edad:"+getEdad()+"\n";
    }

    @Override
    public boolean equals(Object o) {
        boolean rta = false;
        if(o !=null){
            if(o instanceof Persona){
                Persona aComparar = (Persona)o;
                if(((Persona) o).getNombre().equalsIgnoreCase(getNombre())){
                    rta = true;
                }
            }
        }
        return rta;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    @Override
    public int compareTo(Object o) {
        int rta = 0;
        if(o != null){
            if(o instanceof Persona){
                Persona persona = (Persona) o;
                if(getEdad() > persona.getEdad()){
                    rta = 1;
                } else if (getEdad() == persona.getEdad()) {
                    rta = 0;
                } else {
                    rta = -1;
                }
            }
        }
        return rta;
    }
}
