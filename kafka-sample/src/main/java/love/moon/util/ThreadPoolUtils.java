package love.moon.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : ndong
 * date : 2021/4/2 10:04
 * desc :
 */
public class ThreadPoolUtils {

    private ThreadPoolUtils() {
    }

    private static ThreadPoolUtils INSTANCE = new ThreadPoolUtils();

    public static ThreadPoolUtils getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThreadPoolUtils();
        }
        return INSTANCE;
    }

    ExecutorService fixedThreadPool = new ThreadPoolExecutor(
            200, 200, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>()
    );

    public void excute(Runnable serviceWindowTask) {
        fixedThreadPool.execute(serviceWindowTask);
    }

    public ExecutorService getPool(){
        return fixedThreadPool;
    }
}
