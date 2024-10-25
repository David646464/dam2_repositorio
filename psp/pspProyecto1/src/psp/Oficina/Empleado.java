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
                oficina.trabajar(this);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
