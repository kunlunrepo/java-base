package thread.dto;

import java.util.concurrent.Callable;

/**
 * description :
 *
 * @author kunlunrepo
 * date :  2023-05-17 09:59
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        int count = 0;
        for (int i = 0; i < 100; i++) {
            count += i;
        }
        return count;
    }
}
