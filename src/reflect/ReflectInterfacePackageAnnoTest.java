package reflect;

import reflect.dto.Student;

import java.lang.annotation.Annotation;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-15 21:09
 */
public class ReflectInterfacePackageAnnoTest {
    public static void main(String[] args) {
        Class cls = Student.class;

        // 获取运行时类的接口
        System.out.println("------------------------");
        Class[] interfaces = cls.getInterfaces();
        for (Class in: interfaces) {
            System.out.println("接口："+ in);
        }

        // 获取父类的接口
        Class superclass = cls.getSuperclass();
        Class[] interfaces1 = superclass.getInterfaces();
        for (Class aClass : interfaces1) {
            System.out.println("父类接口：" + aClass);
        }

        // 获取运行时类所在的包
        System.out.println("------------------------");
        Package aPackage = cls.getPackage();
        System.out.println("包：" + aPackage);
        System.out.println("包名：" + aPackage.getName());

        // 获取运行时类的注解
        System.out.println("------------------------");
        Annotation[] annotations = cls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解："+ annotation);
        }

    }
}
