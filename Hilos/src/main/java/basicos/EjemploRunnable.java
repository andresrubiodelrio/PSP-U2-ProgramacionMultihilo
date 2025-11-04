package basicos;

public  class EjemploRunnable {

    public static void main(String[] args) {
//        Despegue hilo1 = new Despegue(1);
//        Despegue hilo2 = new Despegue(2);
//        hilo1.run();
//        hilo2.run();

        Thread hilo1=new Thread(new Despegue(1));
        Thread hilo2=new Thread(new Despegue(2));

        hilo1.start();
        hilo2.start();
        System.out.println("Comienza la cuenta atrás!");
    }

    public static class Despegue implements Runnable {
        private int cuentaAtras = 10;
        private int id;

        public Despegue() {}

        public Despegue(int id) {
            if (id<0)
                throw new IllegalArgumentException("ERROR: El id no puede ser negativo.");

            this.id = id;
        }

        @Override
        public void run() {
            while (cuentaAtras > 0) {
                System.out.println("#" + id + " (" + cuentaAtras + ")" );
                cuentaAtras--;
            }

//            System.out.println("Soy el hilo: "+ Thread.currentThread().getName());
            System.out.println("Lanzamiento (" + id + ")");
        }


    }
}
