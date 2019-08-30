package apackage;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Arrays;
import java.util.List;

public class B {
    private A a;
    private static String string;
    public B() {
    }

    public B(A a) {
        this.a = a;
    }

    public void printList(List<C>list) {
      a.setA(6);
      string = "hi";
        A al = new A(1);
        list.stream()
                .forEach(c -> {
                    System.out.println(a.processList(c));
                    printString();
                    System.out.println(string);
                    System.out.println(al);
                    System.out.println("====================");});
        a.setA(9);
        a = new A();
        string = "hioo";
        al.setA(5);
    }
    public void printString() {
        System.out.println("hello");
    }
    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }

    public static void main(String[] args) {
        B b = new B(new A());
        b.printList(Arrays.asList(new C("1"),new C("1"),new C("1"),new C("1")));
    }
}
