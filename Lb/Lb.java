package Lb;
import java.util.Scanner;

public class Lb { 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int b_size, b_content, rem_buc_content, num, rec_pkt_size, buc_rate;

        System.out.println("Enter bucket size: ");
        b_size = sc.nextInt();
        System.out.println("Enter bucket rate: ");
        buc_rate = sc.nextInt();
        System.out.println("Enter number of packets: ");
        num = sc.nextInt();
        int a[] = new int[num];
        System.out.println("Enter packets:");
        for (int i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();
        }

        rem_buc_content = 0;
        b_content = 0;
        System.out.println("rec_pkt_size\t" + "b_content\t" +  "acc/rej\t" + "rem_buc_content ");
        System.out.println("====================================================================");

        for (int i = 0; i < a.length; i++) {
            rec_pkt_size = a[i];
            b_content = rec_pkt_size + rem_buc_content;

            if(b_content > b_size){
                b_content = rem_buc_content;
                rem_buc_content = b_content - buc_rate;
                System.out.println(rec_pkt_size + "\t\t" + b_content +  "\t\trej\t\t" + rem_buc_content);
            }

            else {
                rem_buc_content = b_content - buc_rate;
                System.out.println(rec_pkt_size + "\t\t" + b_content +  "\t\tacc\t\t" + rem_buc_content);
                
            }

           
        }

        while(rem_buc_content > 0){
            b_content = rem_buc_content;
            rem_buc_content = rem_buc_content - buc_rate;
            if(rem_buc_content < 0){
                rem_buc_content = 0;
            }

        }
        System.out.println("-" + "\t\t" + b_content +  "\t\t--\t\t" + rem_buc_content);

    }
}




