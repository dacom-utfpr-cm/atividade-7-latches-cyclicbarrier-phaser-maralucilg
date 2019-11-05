package Latch;

import java.util.concurrent.CountDownLatch;

/*
 *  One Dimensional Stencil: Solução com Latch
 *  
 *  @maralucilg
 */
public class Latch implements Runnable {
	static boolean control; // controle do loop
	static boolean flag; // controle de mudança
	int position;
	static float[] v = new float[] {1,2,2,1};
	static float[] v2 = v.clone();
	CountDownLatch latch;
	
	Latch(CountDownLatch latch, int position) {
		
		this.latch = latch;
		this.position = position;
		
	}

	@Override
	public void run() {
		
		v2[position] = (v[position - 1] + v[position + 1])/2;
		flag = flag || (v2[position] != v[position]);
		latch.countDown();
		
		
	}

}
