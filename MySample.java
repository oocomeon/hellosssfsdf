package apackage;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@MyClassAnnotation(uri = "com.ross.Mysample", desc = "The class name")
public class MySample {
    @MyFiledAnnotation(uri = "com.ross.MySample#id", desc = "The class field")
    public String id;
    @MyConstructorAnnotation(uri = "com.ross.MySample#MySample", desc = "The default constructor")
    public MySample() {

    }
    @MyMethodAnnotation(uri = "com.ross.MySample#setId", desc = "The class method")
    public void setId(String id) {
        this.id = id;
    }

    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        MySample mySample = new MySample();
        MyClassAnnotation myClassAnnotation = MySample.class.getAnnotation(MyClassAnnotation.class);
        System.out.println("Class's uri: " + myClassAnnotation.uri() + "; desc : " + myClassAnnotation.desc());
        Constructor constructor = MySample.class.getConstructor();
        MyConstructorAnnotation myConstructorAnnotation = (MyConstructorAnnotation) constructor.getAnnotation(MyConstructorAnnotation.class);
        System.out.println("Constructor's uri: " + myConstructorAnnotation.uri() + "; desc " + myConstructorAnnotation.desc());
        Method method = MySample.class.getDeclaredMethod("setId", String.class);
        MyMethodAnnotation myMethodAnnotation = method.getAnnotation(MyMethodAnnotation.class);
        System.out.println("Method's uri:" + myMethodAnnotation.uri() + "; desc :" + myMethodAnnotation.desc());
        Field field = mySample.getClass().getDeclaredField("id");
        MyFiledAnnotation myFiledAnnotation = field.getAnnotation(MyFiledAnnotation.class);
        System.out.println("Field's  uri: " + myFiledAnnotation.uri() + ": desc : " + myFiledAnnotation.desc());
    }
}
