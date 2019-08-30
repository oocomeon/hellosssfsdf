package apackage;

public class C {
    private String c;

    public C(String c) {
        this.c = c;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    @Override
    public String toString() {
        return "C{" +
                "c='" + c + '\'' +
                '}';
    }
}
