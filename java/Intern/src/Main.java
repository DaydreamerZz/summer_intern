public class Main extends Thread{
    @Override
    public void run() {
        try{
            Thread.sleep(1000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        int a = 3, b = 3;
        Main main = new Main();
        main.start();
    }
}

class Singleton{
    private static
}
