package designpattern.observer;

public class BinaryObserver extends Observer{
    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }
    @Override
    void update() {
        System.out.println("Binary:" + Integer.toBinaryString(subject.getState()));
    }
}
