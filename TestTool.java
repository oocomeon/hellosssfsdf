package apackage;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestTool {
    // static int errornum = 0;
    public static void main(String[] args) {
        NoBug nobug = new NoBug();
        Class clazz = nobug.getClass();
        Method[] methods =clazz.getDeclaredMethods();
        StringBuffer log = new StringBuffer();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        Arrays.stream(methods)
                .filter(method -> method.isAnnotationPresent(JieCha.class))
                .forEach(method -> {
                    try {
                        method.setAccessible(true);
                        method.invoke(nobug, null);
                    } catch (Exception e) {
                        list.set(0,list.get(0) + 1);
                        log.append(method.getName());
                        log.append(" ");
                        log.append("has error:");
                        log.append("\n\r caused by ");
                        log.append(e.getCause().getClass().getSimpleName());
                        log.append("\n\r");
                        log.append(e.getCause().getMessage());
                        log.append("\n\r");
                    }
                });
        log.append(clazz.getSimpleName());
        log.append(" has ");
        log.append(list.get(0));
        log.append(" error.");
        System.out.println(log);
    }
}
