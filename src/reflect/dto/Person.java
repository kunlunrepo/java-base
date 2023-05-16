package reflect.dto;

import java.io.Serializable;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-15 16:51
 */
public class Person implements Serializable {

    private int age;

    public String name;

    private void eat() {
        System.out.println("Person---eat");
    }

    public void sleep() {
        System.out.println("Person---sleep");
    }

}
