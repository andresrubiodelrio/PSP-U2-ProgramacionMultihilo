package basicos;

public class CreacionHilosExpresionLambda {
    public static void main(String[] args)  {
        Runnable runnable=()->{
            System.out.println("[2]Saludos desde un hilo anónimo Runnable");

            //Para usar los métodos básicos de Thread (getName, setName, ...) debemos obtener el objeto Thread
            //asociado al hilo.
            System.out.println("[2]Mi nombre inicial es:"+Thread.currentThread().getName());

            //Modificamos el nombre del hilo
            Thread.currentThread().setName("Hilo Extend Thread");
            System.out.println("[2]Mi nombre tras la modificación realizada es: " + Thread.currentThread().getName()+"\n");
        };

        Thread hilo1=new Thread(runnable);

        System.out.println("[1]Soy el hilo principal y me llamo: " + Thread.currentThread().getName());
        System.out.println("[1]Voy a ejecutar un hilo de una clase anónima que implementa la interfaz Runnable\n");

        hilo1.start();

        System.out.println("[3]Soy el hilo principal y me llamo: " + Thread.currentThread().getName());

    }
}
