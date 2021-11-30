package src;

public class sort {
		public static int[] ordina(int[] numeri) {
			 for(int i = 0; i < 10; i++) {
				 boolean flag = false;
				 for(int j = 0; j <9; j++) {
					 if(numeri[j]>numeri[j+1]) {
			                int k = numeri[j];
			                numeri[j] = numeri[j+1];
			                numeri[j+1] = k;  
			                flag=true;
				 }
			 }
				 if(!flag) break;
		}
			 return numeri;
		}
		}

