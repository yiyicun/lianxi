package thread.executor;

import java.util.concurrent.*;

public class ThreadPoolDemo {


        public static void main(String[] args) {

            ExecutorService executorService = Executors.newFixedThreadPool(4);

            for (int i = 0; i < 5; i++) {
                int index = i;
                executorService.execute(() -> divTask(100, index));
            }
            executorService.shutdown();
        }

        private static void divTask(int a, int b) {
            double result = a / b;
            System.out.println(result);
        }


}

