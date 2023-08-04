import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

public class CallableClass implements Callable
{
    private List<Integer> list;
    public CallableClass(List<Integer> list)
    {
        this.list = list;
    }

    @Override
    public List<Integer> call() throws Exception
    {
        for (int i = 0; i < list.size(); i++)
        {
            list.set(i,list.get(i)+10);
        }
        System.out.println(Thread.currentThread().getName()+" Отработал");
        return list ;
    }
}
