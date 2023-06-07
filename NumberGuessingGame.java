import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Random ran = new Random();
        Scanner sc = new Scanner(System.in);

        int count =1 ;
        int x = ran.nextInt(10);
        System.out.println("Enter the no: ");
        for(int i=0;i<5;i++)
            {
                int y = sc.nextInt();
            
            if(x<y)
            {
                System.out.println("Your no is greater than random no");
            }
            else if(x>y)
            {
                System.out.println("Your no is smaller than random no");
            }
            else {
                System.out.println("Congrats !! you matched the random no.");
                System.out.println("Your score is: "+ count);
                break;
            }
            if(count==3)
            {
                System.out.println("Sorry, you lost !!");
            }
            count+=1;
        }
    }
}
