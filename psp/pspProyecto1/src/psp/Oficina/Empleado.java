package psp.Oficina;

public class Empleado extends Thread{


    private String nombre;
    private boolean trabajando = false;
    private Oficina oficina;

    public Empleado(String nombre, Oficina oficina){
        this.nombre = nombre;
        this.oficina = oficina;
    }

    public String getNombre(){
        return nombre;
    }

    public boolean isTrabajando(){
        return trabajando;
    }

    public void setTrabajando(boolean trabajando){
        this.trabajando = trabajando;
    }

    @Override
    public void run(){
        try{
            Thread.sleep((long)(Math.random()*1000));
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        if(!trabajando){
            try {
                trabajar();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private synchronized void trabajar() throws InterruptedException {
        if (!oficina.isTrabajando()){
            System.out.println(getNombre() + " zzzz");
            this.wait();
            if (oficina.isTrabajando()){
                System.out.println(getNombre() + " buenos días jefe, aquí estoy trabajando");
                return;
            }
            return;
        }else{
            System.out.println(getNombre() + " Hola jefe!, me pongo a trabajar");
            return;
        }
    }


}
