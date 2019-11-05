package Sequential;

import java.util.Arrays;

/*
 *  One Dimensional Stencil: Solução Sequencial
 *  
 *  @maralucilg
 */

public class SequencialStencil {

	public static void main(String[] args) {
		boolean flag = true; // controle de mudança
		float[] v = new float[] {1,2,2,1};
		float[] v2 = v.clone();
		int num_int = 0;
		
		while(flag) {
			flag = false;
			num_int++;
			
			for(int i = 1; i < v.length - 1; i++) {
				
				v2[i] = (v[i-1]+v[i+1])/2;
				flag = flag || (v2[i] != v[i]);	
			}
			
			v = v2.clone();
			System.out.println("i" + num_int);
			System.out.println(Arrays.toString(v));
		}

	}

}
