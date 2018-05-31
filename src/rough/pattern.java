package rough;

public class pattern {
	public static void main(String[] args) {
		int no = 4;
		
		for(int i=1; i<=no; i++)
		{
			for(int k=1; k<=no-i; k++)
			{
				System.out.print(" ");
			}
			for(int j = 1; j<=i; j++)
			{
				System.out.print("*");
			}
			
			System.out.println();
		}
	}

}
