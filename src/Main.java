import Persona.Persona;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Persona persona1 = new Persona(123,"Fede",28);
        Persona persona2 = new Persona(456,"Juan",29);
        Persona persona3 = new Persona(789,"Maria",21);
        Persona persona4 = new Persona(159,"Pedro",28);
        Persona persona5 = new Persona(753,"Ana",26);
        Persona persona6 = new Persona(123,"Fede",28); // Esta persona no se agrega por el equals

        ArrayList<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        listaPersonas.add(persona6);

        System.out.print("Array List de personas: \n");

        for(Persona persona : listaPersonas){
            System.out.printf(persona.toString());
        }

        System.out.print("HashMap de Peronas\n");

        HashMap<Integer,Persona> mapaPersonas = new HashMap<>();
        for(Persona persona : listaPersonas){
            mapaPersonas.put(persona.getDni(),persona);
        }

        listaPersonas.remove(persona1);


        Iterator <Map.Entry<Integer,Persona>> iteratorMapa = mapaPersonas.entrySet().iterator();

        while (iteratorMapa.hasNext()){
            Map.Entry<Integer,Persona> entradaMapa = iteratorMapa.next();
            System.out.printf("Clave: %d Valor: %s%n", entradaMapa.getKey(), entradaMapa.getValue());
        }


        HashSet<Persona> hashSetPersonas = new HashSet<>();

        for(Persona persona : listaPersonas){
            hashSetPersonas.add(persona);
        }

        System.out.print("HashSet de Personas\n");


        Iterator<Persona> iterator = hashSetPersonas.iterator();
        int i = 0;
        while (iterator.hasNext()){
            Persona aux = iterator.next();
            System.out.printf("Persona %d: %s",(i+1),aux);
            i++;
        }
        
        System.out.printf("La mayor persona es: \n"+Collections.max(hashSetPersonas));
        System.out.println("La menor persona es :\n"+Collections.min(hashSetPersonas));

        String[] nombres = {
                "Juan", "Ana", "PepitoxD", "Federico", "MariaNuncaFalta",
                "Carlos", "Laura", "Pedro", "Sofia", "Luisa"
        };
        int[] edades = {25, 30, 35, 40, 45, 50, 55, 60, 65, 70};
        int[] dni = {12345678, 23456789, 34567890, 45678901, 56789012,
                67890123, 78901234, 89012345, 90123456, 12345678};

        List<Persona> personas = generarListaAleatoria(nombres, edades, dni);

        // Mostrar el contenido de la lista
        for (Persona persona : personas) {
            System.out.println(persona);
        }
    }

    public static List<Persona> generarListaAleatoria(String[] nombres, int[] edades, int[] dni) {
        List<Persona> lista = new ArrayList<>();

        Random rand = new Random();

        for (int i = 0; i < nombres.length; i++) {
            int randomEdadIndex = rand.nextInt(edades.length);
            int randomDniIndex = rand.nextInt(dni.length);

            Persona persona = new Persona(dni[randomDniIndex], nombres[i], edades[randomEdadIndex]);
            lista.add(persona);
        }

        return lista;
    }
}
