package reflect;

import reflect.dto.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-15 16:48
 */
public class ReflectConstructorTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 获取字节码信息
        Class cls = Student.class;

        // 通过字节码获取构造器
        System.out.println("--------通过字节码获取构造器--------");
        Constructor[] cs1 = cls.getConstructors();
        for (Constructor constructor : cs1) {
            System.out.println(constructor);
        }

        // 获取运行时类的全部修饰符的构造器
        System.out.println("--------获取运行时类的全部修饰符的构造器--------");
        Constructor[] cs2 = cls.getDeclaredConstructors();
        for (Constructor constructor : cs2) {
            System.out.println(constructor);
        }

        // 获取指定的构造器
        System.out.println("--------获取指定的构造器--------");
        Constructor c1 = cls.getConstructor(); // 获取空构造器
        System.out.println(c1);

//        Constructor c2 = cls.getConstructor(double.class, double.class); // 获取两个参数的有参构造器
//        System.out.println(c2);

        Constructor c3 = cls.getDeclaredConstructor(int.class); // 获取一个参数的有参构造，并且是private修改时的
        System.out.println(c3);

        Object o1 = c1.newInstance();
        System.out.println(o1);

        Object o2 = c3.newInstance(12);
        System.out.println(o2);

    }
}
