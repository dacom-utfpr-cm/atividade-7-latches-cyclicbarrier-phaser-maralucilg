package CyclicBarrier;

import java.util.Arrays;
import java.util.concurrent.CyclicBarrier;

/*
 *  One Dimensional Stencil: Solução com Cyclic Barrier
 *  
 *  @maralucilg
 */

public class MainCyclicBarrier {

	public static void main(String[] args) {
		CyclicBarrierr.barrier = new CyclicBarrier(CyclicBarrierr.v.length - 2, new Runnable() {
			@Override
			public void run() {
				CyclicBarrierr.num_int.incrementAndGet();
				CyclicBarrierr.v = CyclicBarrierr.v2.clone();
				CyclicBarrierr.control = CyclicBarrierr.flag;
				CyclicBarrierr.flag = false;
			}
		});
		
		Thread[] threads = new Thread[CyclicBarrierr.v.length - 2];
		
		for(int i = 1; i < CyclicBarrierr.v.length - 1; i++) {
			
			threads[i-1] = new Thread(new CyclicBarrierr(i));
			threads[i-1].start();
		}
		
		for(int i = 1; i < CyclicBarrierr.v.length - 1; i++) {
			
			try {
				threads[i-1].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("i" + CyclicBarrierr.num_int);
		System.out.println(Arrays.toString(CyclicBarrierr.v));
		

	}

}
