package reflect;

import base.Test;
import reflect.dto.Person;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-16 10:41
 */
public class ReflectClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        // 方式1：通过getClass()方法
        System.out.println("--------通过getClass()方法--------");
        Person p = new Person();
        Class<? extends Person> c1 = p.getClass();
        System.out.println(c1);

        // 方式2：通过内置class属性
        System.out.println("--------通过内置class属性--------");
        Class c2 = Person.class;
        System.out.println(c2);
//        System.out.println(c1==c2);

        // 方式3：通过Class类提供的静态方法forName
        System.out.println("--------通过Class类提供的静态方法forName--------");
        Class c3 = Class.forName("reflect.dto.Person");
        System.out.println(c3);

        // 方式4：通过类的加载器
        System.out.println("--------通过类的加载器--------");
        ClassLoader loader = Test.class.getClassLoader();
        Class<?> c4 = loader.loadClass("reflect.dto.Person");
        System.out.println(c4);
//        System.out.println(c3==c4);

    }
}
