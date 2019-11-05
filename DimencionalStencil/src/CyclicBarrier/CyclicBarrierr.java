package CyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.atomic.AtomicInteger;


/*
 *  One Dimensional Stencil: Solução com Cyclic Barrier
 *  
 *  @maralucilg
 */
public class CyclicBarrierr implements Runnable {
	
	static boolean control; // controle do loop
	static boolean flag; // controle de mudança
	int position;
	static float[] v = new float[] {1,2,2,1};
	static float[] v2 = v.clone();
	static CyclicBarrier barrier;
	static CyclicBarrier matchpoint = new CyclicBarrier(v.length - 2);
	static AtomicInteger num_int = new AtomicInteger(0);
	
	CyclicBarrierr(int position) {
		
		this.position = position;
	}

	@Override
	public void run() {
		while(control) {
			v2[position] = (v[position - 1] + v[position + 1])/2;
			flag = flag || (v2[position] != v[position]);
			
			try {
				barrier.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}

}
