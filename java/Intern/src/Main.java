import java.util.ArrayList;

import static java.lang.System.out;

public class Main{

    public class Member{
        int id;
        String name;
        public Member(String name){
            this.name = name;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "name=" + name +
                    '}';
        }

        public void leave() {
            members.remove(this);
        }
    }

    private static ArrayList<Member> members;

    public Member enroll(String name){
        Member newMember = new Member(name);
        members.add(newMember);
        return newMember;
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.test(main);
    }
    public void test(Main main){
        members = new ArrayList<>();
//        main.test();
        Main.Member fred = main.enroll("fred");
        Main.Member tom = main.enroll("tom");
        for(Main.Member member : members)
            out.println(member);
        fred.leave();
        for(Main.Member member : members)
            out.println(member);
    }
}
