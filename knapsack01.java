import java.util.Scanner;

class ks_01 {

    int N; // Number of items (objects)

    int weights[];

    int values[];

    int table[][]; // DP table to store the total values.

    int W; // Sack capacity // Function to read data of all items

    public void read_data()

    {

        // reading number of items and capacity of knapsack

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter no of items and sack capacity");

        N = sc.nextInt();

        W = sc.nextInt();

        weights = new int[N + 1]; // item numbers are from 1 to N

        values = new int[N + 1];

        table = new int[N + 1][W + 1];

        System.out.println("Read item data");

        for (int i = 1; i <= N; i++)

        {

            System.out.println("Enter weight and value of item " + i);

            weights[i] = sc.nextInt();

            values[i] = sc.nextInt();

        }

    }

    public void find_value() {

        // find the knapsack value and objects selected

        int i, j;

        for (i = 0; i < W + 1; i++)

            table[0][i] = 0;

        for (i = 0; i < N + 1; i++)

            table[i][0] = 0;

        // Let's fill the values row by row

        for (i = 1; i < N + 1; i++)

            for (j = 1; j < W + 1; j++)

            {

                // Given a weight, check if the value of the current item + value //with
                // previous items is greater than the value

                // without the current item itself

                if (weights[i] <= j && (table[i - 1][j]) <

                        (table[i - 1][j - weights[i]] + values[i]))

                    table[i][j] = table[i - 1][j - weights[i]] + values[i];

                else

                    // If the current item's weight is more than the running weight,

                    // Just carry forward the value without the current item

                    table[i][j] = table[i - 1][j];

            }

        System.out.println("Total value of items taken= " + table[N][W]);

        System.out.println("Selected items are:");

        j = W;

        for (i = N; i > 0; i--)

            if (table[i][j] != table[i - 1][j])

            {

                System.out.println(i);

                j = j - weights[i];

            }

    }

}

public class knapsack01 {

    public static void main(String[] arg) {

        ks_01 ks_obj = new ks_01();

        ks_obj.read_data();

        ks_obj.find_value();

    }

}