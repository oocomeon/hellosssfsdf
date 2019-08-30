package apackage;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Stream;

public class FruitInfoUtil {
    public static void getFruitInfo(Class<?> clazz) {

        Field[] fields = clazz.getDeclaredFields();
        /*for (Field field : fields) {
            if (field.isAnnotationPresent(FruitName.class)) {
                FruitName fruitName = field.getAnnotation(FruitName.class);
                strFruitName = strFruitName + fruitName.value();
                System.out.println(strFruitName);
            } else if (field.isAnnotationPresent(FruitColor.class)){
                FruitColor fruitColor = field.getAnnotation(FruitColor.class);
                strFruitColor = strFruitColor + fruitColor.fruitColor();
                System.out.println(strFruitColor);
            } else if (field.isAnnotationPresent(FruitProvider.class)) {
                FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
                strFruitProvider = "供应商编号: " + fruitProvider.id() + "供应商名称:" + fruitProvider.name()
                        + "供应商地址:" + fruitProvider.address();
                System.out.println(strFruitProvider);
            }
        }*/
        String[] strs = new String[] {
                "水果名称:", "水果颜色:","供应商信息:"};



        Stream<Field> s = Arrays.stream(fields);
       // Arrays.stream(fields)
                s.filter(field -> field.isAnnotationPresent(FruitName.class))
                .forEach(field -> {
                    strs[0] += field.getAnnotation(FruitName.class).value();
                    System.out.println(strs[0]);
                });
     //.   s.stream(fields)
               s.filter(field -> field.isAnnotationPresent(FruitColor.class))
                .forEach(field -> {
                    strs[1] += field.getAnnotation(FruitColor.class).fruitColor();
                    System.out.println(strs[1]);
                });
        Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(FruitProvider.class))
                .forEach(field -> {
                    FruitProvider fp = field.getAnnotation(FruitProvider.class);
                    strs[2] += "供应商编号: " + fp.id() + "供应商名称:" + fp.name()
                            + "供应商地址:" + fp.address();
                    System.out.println(strs[2]);
                });

    }
}
