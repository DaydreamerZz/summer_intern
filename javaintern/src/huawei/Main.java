import static java.lang.System.out;

public class Main {

    public static void oddOrEven(int value){
        if((value & 1) > 0){
            out.println("odd");
        }else
            out.println("even");
    }
    public static void main(String[] args) {
        oddOrEven(1);
    }
}
