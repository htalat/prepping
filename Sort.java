/*	Sort
	bubbleSort
	selectionSort
	bucketSort
	mergeSort
    insertionSort
*/
public class Sort
{
	public Sort()
	{

	}
    //------------------------------------------------------------

	public void bubbleSort(int[] array)
	{
		for(int i=0;i<array.length-1;i++)
		{
			for(int j=0;j<array.length-i-1;j++)
			{
				if(array[j] > array[j+1])
				{
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

    //------------------------------------------------------------

	public void selectionSort(int[] array)
	{
		int temp,min;
		for(int i=0;i<array.length-1;i++)
		{
			min= i;
			for(int j=i+1;j<array.length;j++)
			{
				if(array[j] < array[i])
				{
					min = j;
				}
			}

			temp = array[i];
			array[i] = array[min];
			array[min] = temp;
		}
	}

    //------------------------------------------------------------

	public void bucketSort(int[] array)
	{
		int min = array[0], max = min;

		for(int i=1;i<array.length;i++)
		{
			if(array[i]< min)
				min = array[i];
			else if(array[i] > max)
				max = array[i];
		}

		int bucket[] = new int[max-min+1];
		for( int i = 0; i < array.length; i++ )                
      		bucket[array[i]-min]++;

    	int i = 0;                                  
    	for( int b = 0; b < bucket.length; b++ )   
      	{	for( int j = 0; j < bucket[b]; j++ )     
        	{
        		array[i++] = b+min; 
        	}	 
        }    

    }

    //------------------------------------------------------------
    public void mergeSort(int[] array, int l , int r )
    {
    	if( l < r )
    	{
    		int mid = (l + r)/2;
    		mergeSort(array,l,mid);
    		mergeSort(array,mid+1,r);
    		merge(array,l,mid,r);
    	}
    }

    public void merge(int[] array, int l , int m , int r)
    {
    	int n1 = m-l +1;
    	int n2 = r - m;

    	int l1[] = new int[n1];
    	int l2[] = new int[n2];

    	for(int i =0; i < n1;i++)
    		l1[i] = array[l+i];

    	for(int i=0;i<n2;i++)
    		l2[i] = array[m+i + 1];

    	int i=0,j=0,k=l;

    	while(i < n1 && j < n2)
    	{
    		if(l1[i] < l2[j])
    		{
    			array[k] = l1[i];
    			i++;
    		}else
    		{
    			array[k] = l2[j];
    			j++;
    		}
    			k++;
    	}

    	while(i < n1)
    	{
    		array[k] = l1[i];
    		i++; k++;
    	}

       	while(j < n2)
    	{
    		array[k] = l2[j];
    		j++; k++;
    	}
    }
    //------------------------------------------------------------
    // demo : http://me.dt.in.th/page/Quicksort/

    public void quickSort(int[] arr, int l, int r)
    {
        int middle = l + (r-l)/2;
        int pivot = arr[middle];

        int i = l , j = r;

        while(i <= j)
        {
            while(arr[i]<arr[middle])
                i++;
            while(arr[j] > arr[middle])
                j--;

            if(i<=j)
            {
                swap(arr,i,j);
                i++; 
                j--;
            }

        }

        if(l < j)
            quickSort(arr,l,j);

        if(r > i)
            quickSort(arr,i,r);

    }

    public void swap(int[] arr, int a , int b)
    {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }

    //------------------------------------------------------------
	
    public void insertionSort(int arr[]) 
    {
        int n = arr.length;

        for (int i = 1; i< n; i++) 
        {
            int tmp = arr[i];
            int j = i-1;
            while ( (j > -1) && ( arr [j] > tmp ) )
            {
                arr [j+1] = arr [j];
                j--;
            }
            arr[j+1] = tmp;
        }
    }

}