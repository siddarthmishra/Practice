package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

// https://www.baeldung.com/java-executor-service-tutorial
public class ExecutorServiceDemo1 {

	private static final int THREAD_COUNT = 10;

	public static void main(String[] args) {

		Random random = new Random();
		ExecutorService service = Executors.newFixedThreadPool(THREAD_COUNT);
		List<Future<String>> list = new ArrayList<>();
		boolean[] doneIndex = new boolean[THREAD_COUNT];
		List<Integer> exceptionInt = List.of(6, 12, 18);

		for (int i = 0; i < THREAD_COUNT; i++) {
			final int index = i;
			Callable<String> c = () -> {
				int r = random.nextInt(1, 20);
				try {
					Thread.sleep(1000 * r);
				} catch (Throwable t) {
					t.printStackTrace();
				}
				if (exceptionInt.contains(r)) {
					throw new RuntimeException("Exception Integer Matched : " + "INDEX=" + index + "#RANDOM=" + r);
				}
				return (Thread.currentThread().getName() + "#INDEX=" + index + "#RANDOM=" + r);
			};
			list.add(service.submit(c));
		}
		int countDown = THREAD_COUNT;
		while (countDown > 0) {
			for (int i = 0; i < THREAD_COUNT; i++) {
				if (countDown == 0) {
					break;
				}
				if (doneIndex[i]) {
					continue;
				}
				Future<String> fs = list.get(i);
				if (fs.isDone()) {
					doneIndex[i] = true;
					countDown--;
					try {
						String result = fs.get();
						System.out.println(result);
					} catch (ExecutionException | InterruptedException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		service.shutdown();
		try {
			if (!service.awaitTermination(10, TimeUnit.SECONDS)) {
				service.shutdownNow();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
