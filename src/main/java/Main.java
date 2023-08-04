import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.*;

public class Main
{
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        System.out.println("Введите число элементов");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(bufferedReader.readLine());
        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());
        Random random = new Random();
        for (int i = 0; i < count; i++)
        {
            list.add(random.nextInt(10)+1);
        }
        System.out.println("Исходный массив");
        for (int i:list)
        {
            System.out.print(i+" ");
        }
        System.out.println();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Integer> list1 = new ArrayList<Integer>();
        FutureTask<List> integerFutureTask = new FutureTask<>(new CallableClass(list));
        executorService.execute(new Thread(integerFutureTask));
        list1.addAll(integerFutureTask.get());
        for (int i: list1)
        {
            System.out.print(i+" ");
        }
        executorService.shutdown();
    }
}
