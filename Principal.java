/*
 * Daniel Machic (22118)
 * HT8
 * Clase principal del programa
 */


import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;


 public class Principal{

    public static void main(String[] args){


        ArrayList<String> FileLines = new ArrayList<>();

        File file = new File("C:/Ejemplos/procesos.txt"); 
        try {
            try (BufferedReader br = new BufferedReader(new FileReader(file))){
                while(br.ready()) {
                    FileLines.add(br.readLine());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Utilizando la clase VectorHeap para los procesos

        System.out.println("\n ***** Cola de prioridad utilizando VectorHeap *****\n");

        // Muestra los procesos que entraran a la cola
        System.out.println(" Procesos a entrar en la cola: \n");
        for(int i = 0; i < FileLines.size(); i++) {
            System.out.println(FileLines.get(i));
        }
        System.out.println("\n");

        List<Proceso> procesos = new ArrayList<>();

        for (String linea : FileLines) {
            String UserName = campos[1];
            int NiceVal = Integer.parseInt(campos[2]);
            String[] campos = linea.split(",");
            String ProssName = campos[0];
            Proceso proceso = new Proceso(ProssName, UserName, NiceVal);
            procesos.add(proceso);
        }

        VectorHeap<Proceso> colaPrioridad = new VectorHeap<Proceso>();
        ArrayList<Integer> valoresPR = new ArrayList<>();

        for (Proceso proceso : procesos){
            int updatedValue = proceso.getNiceVal() + 20 + 100;
            proceso.setNiceVal(updatedValue);
            colaPrioridad.add(proceso);
        }

        while (!colaPrioridad.isEmpty()) {
            Proceso proceso = colaPrioridad.remove();
            int originalValue = proceso.getNiceVal() - 120;
            int newPrioVal = proceso.getPrioVal();
            valoresPR.add(proceso.getNiceVal());
            System.out.println("Nombre del proceso: " + proceso.getProssName() + ", Nombre del usuario: " 
            + proceso.getUserName() + ", Valor nice: " + originalValue + ", Prioridad: " + newPrioVal);
        }

        // Utilizando PriorityQueue de Java Collection Framework
    

        System.out.println("\n ***** Cola de prioridad utilizando Java Collection Framework ***** \n");

        System.out.println(" Procesos a entrar en la cola: \n");
        for(int i = 0; i < FileLines.size(); i++) {
            System.out.println(FileLines.get(i));
        }
        System.out.println("\n");

        PriorityQueue<Proceso> ps = new PriorityQueue<>();

        for (String linea : FileLines) {
            String[] campos = linea.split(",");
            String ProssName = campos[0];
            String UserName = campos[1];
            int NiceVal = Integer.parseInt(campos[2]);
            ps.offer(new Proceso(ProssName, UserName, NiceVal));
        }

        List<Integer> newVal = new ArrayList<>();

        while (!ps.isEmpty()) {
            Proceso proceso = ps.poll();
            int PrioVal2 = proceso.getNiceVal() + 20 + 100;
            newVal .add(PrioVal2);
            System.out.printf("Nombre del proceso: , Nombre del usuario: , Valor nice: , Prioridad: \n",
                proceso.getProssName(), proceso.getUserName(), proceso.getNiceVal(), PrioVal2);
        }

    }   

}

    

