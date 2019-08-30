package apackage;

public class NoBug {
    @JieCha
    private void suanShu() {
        System.out.println("123457689");
    }
    @JieCha
    private void jiafa() {
        System.out.println("1+1=" + (1 + 1));
    }
    @JieCha
    private void jiefa() {
        System.out.println("1*1=" + (1 * 1));
    }
    @JieCha
    private void runException() {
        int[] a = new int[5];
        System.out.println(a[5]);
    }
    @JieCha
    public void runException1() {
        throw new RuntimeException("runE");
    }
}
