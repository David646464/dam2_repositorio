package psp.Oficina;

public class Oficina {
    private boolean trabajando = false;
    private Empleado[] empleados;
    private Jefe jefe;

    public Oficina(int numEmpleados){
        empleados = new Empleado[numEmpleados];
        for(int i = 0; i < numEmpleados; i++){
            empleados[i] = new Empleado("Empleado " + i, this);
        }
        jefe = new Jefe("Jefe", this);
    }


    public  synchronized void trabajar(Jefe jefe){
        System.out.println(jefe.getNombre() + " EL JEFE HA LLEGADO!");
        jefe.setTrabajando(true);
        trabajando = true;
        for(Empleado empleado : empleados){
           empleado.notify();
        }
    }


    public void abrir(){
        for(Empleado empleado : empleados){
            empleado.start();
        }
        jefe.start();
    }

    public boolean isTrabajando(){
        return trabajando;
    }

    public static void main(String[] args){
        Oficina oficina = new Oficina(5);
        oficina.abrir();
    }

}
