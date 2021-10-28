import java.util.Scanner;

public class Main {
    static int counter;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of stations in the assembly line ");
        int stations = sc.nextInt();
        System.out.print("The number of stations are : ");
        System.out.println( stations);

       int[][] a ;
       int [][] t ;
       int []e;
       int []x;

        a = inset_assembly_array(stations);
        t = insert_transport_time_array (stations);
        e = insert_start_end_time();
        x = insert_start_end_time();
        System.out.print("The assembly time is : ");
        System.out.println(AssembleTime(a, t, e, x));
        System.out.print("The primitive operations performed : ");
        System.out.println(counter);
        System.out.println();
        System.out.println("The Activity time of each station  ");
        Display_array(a,stations);
        System.out.println();
        System.out.println("The Transfer cost ");
        Display_array(t,stations);
        System.out.println();
        System.out.println("The Starting time ");
        Display_start_end(e);
        System.out.println();
        System.out.println();
        System.out.println("The Ending time ");
        Display_start_end(x);
    }

    public static int AssembleTime(int a[][], int t[][],
                                   int e[], int x[]) {
        int n = a[0].length;
        counter+=2;// (assignment , array indexing )

        // time taken to leave first station in line 1
        int first = e[0] + a[0][0];
        counter+=5;//  (assignment , array indexing , addition)

        // time taken to leave first station in line 2
        int second = e[1] + a[1][0];
        counter+=5;// (assignment , array indexing , addition)

        counter++; //( assignment i)
        for (int i = 1; i < n; i++) {
        counter+=3;// (comparison , increment(addition) , assignment )

            int up = Math.min(first + a[0][i],
                    second + t[1][i] + a[0][i]),
                    down = Math.min(second + a[1][i],
                            first + t[0][i] + a[1][i]);
            counter+=26;// ( assignment , addition , call function ,array indexing  )

            first = up;
            second = down;
            counter+=2; // (assignment)
        }

        counter+=6;//(assignment , addition , array indexing , )
        first += x[0];
        second += x[1];

        counter+=2;//( return , call function)
        return Math.min(first, second);
    }

    public static int GenerateRandom() {
        int min = 1;
        int max = 10;
        int random_int;
        random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random_int;
    }

    public static int[][] inset_assembly_array(int stat) {
        int[][] temp = new int[2][stat];
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < stat; col++) {
                  temp[row][col] = GenerateRandom();
            }

        }
        return temp;
    }

    public static int[][] insert_transport_time_array(int stat) {
        int[][] temp = new int[2][stat];
        Scanner sc = new Scanner(System.in);
        for (int row = 0; row < 2; row++) {
            for (int col = 0; col < stat; col++) {
                if (col == 0) {
                    temp[row][col] = 0;
                } else {
                    temp[row][col] = GenerateRandom();
                }
            }
        }
        return temp;
    }
    public static int[] insert_start_end_time(){
        int[] temp = new int[2];
        Scanner sc = new Scanner(System.in);
        for ( int count = 0 ; count < 2 ; count++){
            temp[count]= GenerateRandom();
        }

        return temp;
    }

    public static void Display_array(int a[][], int stat ){
        for (int row = 0; row < 2; row++) {
            System.out.print("{");
            for (int col = 0; col < stat; col++) {
                System.out.print(a[row][col]);
                System.out.print(",");
            }
            System.out.println("}");
        }
    }

    public static void Display_start_end(int t[]){
        System.out.print("{");
        for ( int count = 0 ; count < 2 ; count++){
            System.out.print(t[count]);
            System.out.print(",");
        }
        System.out.print("}");
    }
}
