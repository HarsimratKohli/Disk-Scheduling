package diskscheduling;

public class ClookDisk {
	int[] queue;
	int[] finalx;
	int head;
	int n;
	int prev;
	int[] lower1;
	int[] upper1;
	public ClookDisk(int[] scan,int head,int prev)
	{
		queue=scan;
		finalx=new int[queue.length];
		n=queue.length;
		this.head=head;
		this.prev=prev;
	}
	public int[] calculate(){
	int temp,j=0,k=0;
	int[] upper=new int[n];
	int[] lower=new int[n];	
	int[] lower1=new int[n];
	int[] upper1=new int[n];
	for(int i=0;i<n;i++)
	{
		if(queue[i] < head)
		{
			lower[j]=queue[i];
			lower1[j]=queue[i];
			j++;
		}
		else if(queue[i] > head)
		{
			upper[k]=queue[i];
			upper1[k]=queue[i];
			k++;
		}
	}
	
	for(int i=0;i<j;i++)
	{
		for(int l=0;l<j-1;l++)
		{
			if(lower[l] < lower[l+1])
			{
				temp=lower[l];
				lower[l]=lower[l+1];
				lower[l+1]=temp;
			}
			
		}
	}
	for(int i=0;i<j;i++)
	{
		for(int l=0;l<j-1;l++)
		{
			if(lower1[l] > lower1[l+1])
			{
				temp=lower1[l];
				lower1[l]=lower1[l+1];
				lower1[l+1]=temp;
			}
			
		}
	}
	
	for(int i=0;i<k;i++)
	{
		for(int l=0;l<k-1;l++)
		{
			if(upper[l] < upper[l+1])
			{
				temp=upper[l];
				upper[l]=upper[l+1];
				upper[l+1]=temp;
			}
		}
	}
	for(int i=0;i<k;i++)
	{
		for(int l=0;l<k-1;l++)
		{
			if(upper1[l] > upper1[l+1])
			{
				temp=upper1[l];
				upper1[l]=upper1[l+1];
				upper1[l+1]=temp;
			}
		}
	}
	int x=1;
	finalx[0]=head;
	if(prev>head)
	{
	for(int i=1;i<=j;i++)
	{
		finalx[i]=lower[i-1];
		x++;
	}
	for(int i=x,p=0;i<(x+k);i++,p++)
	{
		finalx[i]=upper[p];
	}
	}
	else
	{
		for(int i=0;i<k;i++)
		{
			finalx[i+1]=upper1[i];
			x++;
		}
		for(int i=x,p=0;i<(x+j);i++,p++)
		{
			finalx[i]=lower1[p];
		}
	}
	return finalx;
	}
}