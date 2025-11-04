package basicos;

public class CreacionVariosHilos {
    public static void main(String[] args)
    {
//creamos 2 hilos del tipo Hilo_Thread con 2 constructores
        //diferentes
        Thread hiloThread1 = new HiloThread("Hilo Uno");
        Thread hiloThread2 = new HiloThread();

        //creamos un hilo Runnable en un paso
        Thread hiloRunnable = new Thread(new HiloRunnable("Hilo Tres"));

        //ponemos en marcha los 3 hilos
        hiloThread1.start();

        hiloThread2.start();
        hiloRunnable.start();

        System.out.println("Soy el hilo principal " + Thread.currentThread().getName() + " y he terminado." + " y mi prioridad es: " + Thread.currentThread().getPriority()) ;

    }

    public static class HiloRunnable implements Runnable {

        private String nombre="";

        public HiloRunnable(String nombre)
        {
            this.nombre=nombre;
        }

        //clase que implementa Runnable
        public void run() {
            //redefinimos run() con el código asociado al hilo
            Thread h=Thread.currentThread();

            h.setName(nombre);

            for (int i = 1; i <= 5; i++) {
                System.out.println("Me llamo: "+h.getName()+ " y tengo la prioridad:"+h.getPriority());
            }
        }
    }

    public static class HiloThread extends Thread {
        //clase que extiende a Thread con 2 constructores

        public HiloThread(String nombre) {
            //constructor 1
            this.setName(nombre);
        }

        public HiloThread()
        {
            //constructor 2
        }

        @Override
        public void run() {
            //redefinimos run() con el código asociado al hilo
            for (int i = 1; i <= 5; i++) {
                System.out.println("Me llamo: "+this.getName()+ " y tengo la prioridad:"+this.getPriority());
            }
        }
    }
}
