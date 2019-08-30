package apackage;

import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {

    public static void main(String[] args) {
        TestDto testDto = new TestDto("123", "34");
        TestDto testDto1 = new TestDto("123", "test1");
        TestDto testDto2 = new TestDto("", "test1,test2,test3,test4");

        String sql =  assembleSqlFromObj(testDto);
        String sq2 =  assembleSqlFromObj(testDto1);
        String sq3 =  assembleSqlFromObj(testDto2);
        System.out.println(sql);
        System.out.println(sq2);
        System.out.println(sq3);
    }
    public static String assembleSqlFromObj(Object obj) {
        Table table = obj.getClass().getAnnotation(Table.class);
        StringBuffer sb = new StringBuffer();
        String tableName = table.value();
        sb.append("select *  from " + tableName + " where 1=1");
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field f : fields) {
            String fieldName = f.getName();
            String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Column column = f.getAnnotation(Column.class);
            try {
                if (column != null) {
                    Method method = obj.getClass().getMethod(methodName);
                    String value = (String) method.invoke(obj);
                    if (value != null && !value.equals("")) {
                        if (!isNum(column.value()) && !isNum(value)) {
                            if (value.contains(",")) {
                                sb.append(" and " + column.value() + " in (" + value + ")");
                             } else {
                                sb.append(" and " + column.value() + " like '%" + value + "%' ");
                            }
                        } else {
                            sb.append(" and " + column.value() + "=" + value + " ");
                        }
                    }
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static boolean isNum(String target) {
        boolean isNum = false;
        if (target.toLowerCase().contains("id")) {
            isNum = true;
        }
        if (target.matches("\\d+")) {
            isNum = true;
        }
        return isNum;
    }
}
