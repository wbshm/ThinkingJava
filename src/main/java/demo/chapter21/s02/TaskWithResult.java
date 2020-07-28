package demo.chapter21.s02;

import java.util.concurrent.Callable;

/**
 * @ClassName TaskWithResult
 * @Description TODO
 * @Author wangrq
 * @Date 2020/7/27 10:56
 */
public class TaskWithResult implements Callable<String> {

    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
