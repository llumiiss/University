import java.util.Scanner;
public class Main
{
    public static void main(String[] args)
    {
        int pulse;
        Scanner enter = new Scanner(System.in);

        System.out.println("Analize pulse");
        System.out.println("write your pulse: ");
            if (!enter.hasNextInt())
                System.out.println("not correct defi");
            else
        {
            pulse = enter.nextInt();
            if (pulse < 0) System.out.println("why negative?");
            else if (pulse == 0) System.out.println("bro ur dying");
            else if (pulse < 30) System.out.println("go to dok its too low");
            else if (pulse < 60) System.out.println("pulse is low, but when exercise is ok");
            else if (pulse < 80) System.out.println("all is good");
            else if (pulse < 100) System.out.println("go to dok");
            else if (pulse > 250) System.out.println("IMPOSSIBLE");
        }
    }
}
