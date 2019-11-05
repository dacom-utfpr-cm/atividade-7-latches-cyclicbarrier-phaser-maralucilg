package Latch;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *  One Dimensional Stencil: Solução com Latch
 *  
 *  @maralucilg
 */
public class MainLatch {

	public static void main(String[] args) {
		// https://howtodoinjava.com/java/multi-threading/executor-service-example/
		
		ExecutorService executor = Executors.newFixedThreadPool(Latch.v.length - 2);
		int num_int = 0; // número de iterações
		
		while(Latch.flag) {
			
			CountDownLatch latch = new CountDownLatch(Latch.v.length - 2);
			Latch.flag = false;
			num_int++;
			for(int i = 1; i < Latch.v.length - 1; i++) {
				executor.submit(new Latch(latch, i));
			}
			try {
				latch.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Latch.v = Latch.v2.clone();
			
		}
		
		System.out.println("i" + num_int);
		System.out.println(Arrays.toString(Latch.v));
		executor.shutdown();

	}

}
