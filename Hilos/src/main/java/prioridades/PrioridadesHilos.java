package prioridades;



public class PrioridadesHilos {

    public static void main(String[] args)
    {
        int contador = 5;

        //vectores para hilos de distintas prioridades
        Thread[] hiloMIN = new Thread[contador];
        Thread[] hiloNORM = new Thread[contador];
        Thread[] hiloMAX = new Thread[contador];

        //crea los hilos de prioridad mínima
        for (int i = 0; i < contador; i++) {
            hiloMIN[i] = new Hilo(Thread.MIN_PRIORITY);
        }

        //crea los hilos de prioridad normal
        for (int i = 0; i < contador; i++) {
            hiloNORM[i] = new Hilo();
        }

        //crea los hilos de máxima prioridad
        for (int i = 0; i < contador; i++) {
            hiloMAX[i] = new Hilo(Thread.MAX_PRIORITY);
        }

        System.out.println("Hilos en proceso, espera......\nLos de mayor "
                + "prioridad tienden a terminar antes...\n");

        //inicia los hilos
        for (int i = 0; i < contador; i++) {
            hiloMIN[i].start();
            hiloNORM[i].start();
            hiloMAX[i].start();
        }

    }

    public static class Hilo extends Thread {


        public Hilo() {
            //hereda la prioridad del hilo padre
        }

        public Hilo(int prioridad) {
            //establece la prioridad indicada
            this.setPriority(prioridad);
        }

        @Override
        public void run() {

            //cadena
            String strCadena = "";

            //agrega 20000 caracteres a una cadena vacía
            for (int i = 0; i < 20000; ++i) {
                //imprime el valor en la Salida
                strCadena += "A";
                //yield();
                //yield()sugiere al planficador Java que puede seleccionar otro hilo,
                try
                {
                    sleep(1);
                }
                catch (InterruptedException ex)
                {
                    System.out.println(ex.getMessage());
                }

            }

            System.out.println("El Hilo llamado "+ this.getName() + " y prioridad " + this.getPriority()
                    + " ha terminado.");
        }
    }
}
