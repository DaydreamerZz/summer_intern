package designpattern.observer;

public class HexaObserver extends Observer{
    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    void update() {
        System.out.println("Hexa:" + Integer.toBinaryString(subject.getState()));
    }
}
