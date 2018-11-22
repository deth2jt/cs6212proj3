package cs6212proj3;

public class MVBLNClass 
{
	public static void main(String[] a)
	{
		//test sequences
		int[] seq = { 10, 22, 9, 33, 21, 50, 41, 60 }; 
		int[] seq2 = {10, 100, 300, 400, 50, 4500, 200, 30, 90};
		int[] seq3 = {100,300,400,50};
		
		//System.out.println(toString(maxSum2(seq3,1), 1));
		//System.out.println(toString(maxSum(seq3,1)));
		System.out.println("bsjhdfjhbdhf");
		//setting up test cases
		int[] arrayLength = { 10000000, 20000000, 30000000, 40000000, 50000000, 60000000};
        for(int size = 0; size < arrayLength.length; size++)
        {
        	int  val = (int) (95 + Math.random() * 100);
            int[] aray = new int[arrayLength[size]];
            for(int i = 0; i < arrayLength.length; i++)
            {
            	
            	
            	aray[i] = val + i;
            }
            int k =1;
            if(size >= arrayLength.length/2)
            	k=2;
            long timeStart = System.currentTimeMillis();
            
            
            
            maxSum(aray, k);
            
            
            long timeEnd = System.currentTimeMillis();
            System.out.println("final:"  + " exper: " +  (timeEnd - timeStart)  + " N: " + arrayLength[size] + " k: " + k ); 
        }
	}
	
	
	
	
	
	
	static int[] maxSum(int array[], int k) 
    { 
        
        int MS[] = new int[array.length]; 
        int binary[] = new int[array.length]; 
        
        
        MS[array.length - 1] = array[array.length - 1]; 
        
        for (int i = array.length - 2; i >= 0; i--) { 
        	
        	if (i + k + 1 >= array.length) 
            {
                
        		
        		MS[i] = array[i]+ MS[i + 1];
                if(MS[i] == array[i])
                	binary[i +1] = 0;
                else
                	binary[i +1] = 1;
            }
            else
            {
                if(k ==1 )
            	{
	            	MS[i] = Math.max(array[i] ,  MS[i + 1]); 
	            	MS[i] = Math.max( MS[i],  array[i] + array[i +1 ]);
	            	MS[i] = Math.max( MS[i],  array[i] + MS[i + 2]);
	            	
	            	if(MS[i] ==  MS[i + 1] )
                    	binary[i +1] = 1;
                    else if(MS[i] == array[i] + array[i +1 ])
                    {
                    	
                    	binary[i +1] = 1;
                    	binary[i] = 1;
                    	binary[i +2] = 0;
                    	
                    }
                    else if(MS[i] == array[i] + MS[i + 2])
                    {
                    	binary[i +2 ] = 1;
                    	binary[i+1] = 0;
                    	binary[i] = 1;
                    }
                    else
                    	binary[i +1] = 0;
            	}
            	if(k ==2 )
            	{
            		MS[i] = Math.max(array[i] + MS[i + k],  MS[i + 1]); 
                    MS[i] = Math.max( MS[i], MS[i +k +1 ] + array[i] + array[i +1 ]);
                    
                    if(MS[i] ==  MS[i + 1] )
                    	binary[i +1] = 1;
                    else if(MS[i] == MS[i +k +1 ] + array[i] + array[i +1 ])
                    {
                    	binary[i +k +1] = 1;
                    	binary[i +1] = 1;
                    	binary[i] = 1;
                    	binary[i+ k] = 0;
                    }
                    else if(MS[i] ==array[i] + MS[i + k])
                    {
                    	binary[i +k ] = 1;
                    	binary[i +1] = 0;
                    	binary[i] = 1;
                    }
                    else
                    	binary[i +1] = 0;
            	}
                
                
            }
        } 
  
        
        return binary;
    } 
	
	static int[][] maxSum2(int array[], int k) 
	{
     
		int[][] MVBLN = new int[array.length][k];
		
		for (int m = 0; m < k; m++)
        { 
			for (int i = 0; i < array.length; i++)
	        { 
				MVBLN[i][m] = 0;
	        }
	        
        	
        } 
		
		
		
		for (int m = 1; m < k; m++)
        { 
			for (int i = 1; i < array.length; i++)
	        { 
				MVBLN[i][m] = Math.max(MVBLN[i-1][m] ,MVBLN[i-1][m-1] + array[i]);
				MVBLN[i][m] = Math.max(MVBLN[i][m], MVBLN[i-2][m] + array[i]);
	        }
	        
        	
        } 
  
        return MVBLN; 
    } 
	
	
	
	
	public static String toString(int[] array)
	{
		String str = "";
		
		
				for(int j = 0; j < array.length; j++)
				{
					str += array[j] + "\t";
					
				}
				str += "\n";
		
				
		return str; 
	}
}
