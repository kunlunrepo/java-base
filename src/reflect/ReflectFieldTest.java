package reflect;

import reflect.dto.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-15 17:52
 */
public class ReflectFieldTest {
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {

        Class cls = Student.class;

        // 获取属性
        System.out.println("--------获取属性--------");
        Field[] fields = cls.getFields();
        for (Field field : fields) {
            System.out.println(field);
        }


        // 获取指定属性
        System.out.println("--------获取指定属性--------");
        Field score = cls.getField("score");
        System.out.println(score);

        Field sno = cls.getDeclaredField("sno");
        System.out.println(sno);


        // 获取修饰符
        System.out.println("--------获取修饰符--------");
        int modifiers = sno.getModifiers();
        System.out.println(modifiers);
        System.out.println(Modifier.toString(sno.getModifiers()));

        // 获取属性的数据类型
        System.out.println("--------获取属性的数据类型--------");
        Class clazz = sno.getType();
        System.out.println(clazz.getName());

        // 获取属性的名字
        String name = sno.getName();
        System.out.println(name);

        // 给属性赋值
        Field sco = cls.getField("score");
        Object obj = cls.newInstance();
        sco.set(obj, 98); // 给obj的score属性设置具体的值
        System.out.println(obj);

    }
}
