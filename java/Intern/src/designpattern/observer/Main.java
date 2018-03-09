package designpattern.observer;

public class Main {
    public static void main(String[] args){
        Subject subject = new Subject();

        new BinaryObserver(subject);
        new HexaObserver(subject);

        subject.setState(10);
        subject.setState(2);
    }
}
