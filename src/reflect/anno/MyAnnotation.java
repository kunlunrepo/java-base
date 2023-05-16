package reflect.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-15 16:58
 */
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER,
        ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE }) // 定义当前注解能够修饰程序中的哪些元素
@Retention(RetentionPolicy.RUNTIME) // 定义注解的声明周期
public @interface MyAnnotation {

    String value(); // 属性
}
