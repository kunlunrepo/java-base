package reflect;

import reflect.dto.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-15 20:38
 */
public class ReflectMethodTest {

    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class cls = Student.class;

        // 获取方法
        System.out.println("--------获取方法--------");
        Method[] methods = cls.getMethods(); // 获取运行时类的方法还有所有父类中的方法(被public修饰)
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("--------获取所有方法--------");
        Method[] declaredMethods = cls.getDeclaredMethods(); // 获取运行时类中的所有方法
        for (Method method : declaredMethods) {
            System.out.println(method);
        }

        // 获取指定的方法
        System.out.println("--------获取指定的方法--------");
        Method showInfo1 = cls.getMethod("showInfo");
        System.out.println(showInfo1);

        Method showInfo2 = cls.getMethod("showInfo", int.class, int.class);
        System.out.println(showInfo2);

        Method work = cls.getDeclaredMethod("work");
        System.out.println(work);

        // 获取方法的具体结构
        System.out.println("--------获取方法的具体结构--------");
        System.out.println("方法名：" + work.getName()); // 方法名
        int modifiers = work.getModifiers(); // 修饰符
        System.out.println("修饰符：" + Modifier.toString(modifiers));
        System.out.println("返回值：" + work.getReturnType()); // 返回值
        Class<?>[] parameterTypes = work.getParameterTypes(); // 参数列表
        for (Class<?> parameterType : parameterTypes) {
            System.out.println("参数列表：" + parameterType);
        }

        Method myMethod = cls.getMethod("myMethod"); // 获取注解
        Annotation[] annotations = myMethod.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("注解：" + annotation);
        }

        Class<?>[] exceptionTypes = myMethod.getExceptionTypes(); // 获取异常
        for (Class<?> exceptionType : exceptionTypes) {
            System.out.println("异常：" + exceptionType);
        }

        Object o = cls.newInstance(); // 调用方法
        myMethod.invoke(o); // 调用o对象的myMethod方法

        System.out.println("方法调用结果：" + showInfo2.invoke(o, 12, 45));

    }
}
