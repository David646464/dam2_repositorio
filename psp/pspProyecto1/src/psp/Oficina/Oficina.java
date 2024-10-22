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

    public void trabajar(Empleado empleado){
        System.out.println(empleado.getNombre() + " se pone a trabajar");
        empleado.setTrabajando(true);
        trabajando = true;
    }

    public void descansar(Empleado empleado){
        System.out.println(empleado.getNombre() + " se pone a descansar");
        empleado.setTrabajando(false);
        trabajando = false;
    }

    public void trabajar(Jefe jefe){
        System.out.println(jefe.getNombre() + " se pone a trabajar");
        jefe.setTrabajando(true);
        trabajando = true;
    }

    public void descansar(Jefe jefe){
        System.out.println(jefe.getNombre() + " se pone a descansar");
        jefe.setTrabajando(false);
        trabajando = false;
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
