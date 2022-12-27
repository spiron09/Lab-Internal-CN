import java.util.Scanner;

//crc 
public class crc {
    static int n,m,msb,i,j,k,g[],d[],z[],r[];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of data bits");
        n = sc.nextInt();
        System.out.println("Enter the number of generator bits");
        m = sc.nextInt();
        d = new int[n+m];
        g = new int[m];

        System.out.println("Enter the data bits");
        for(i=0;i<n;i++)
            d[i] = sc.nextInt();

        System.out.println("Enter the generator bits");
        for(i=0;i<m;i++)
            g[i] = sc.nextInt();
        
        crcEval();
        System.out.println("The data bits are");
        for(i=0;i<n+m;i++)
            System.out.print(d[i]);
        
        
    }
}