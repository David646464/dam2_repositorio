package org.example.tarea2.tarea1_1;

public class Main {
    public static void main(String[] args) {
        DatabaseManagerMYSQL databaseManagerMYSQL = new DatabaseManagerMYSQL();
        int filasAfectadas = databaseManagerMYSQL.aumentarSueldoEnUnDepartamento(100, "PERSOAL");
        System.out.println("Filas afectadas: " + filasAfectadas);
    }

}
