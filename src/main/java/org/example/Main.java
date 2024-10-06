import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        // Задание 1
        Button button = new Button();
        button.click();
        button.click();

        // Задание 2
        Balance balance = new Balance();
        balance.addLeft(10);
        balance.addRight(8);
        balance.result();
        balance.addRight(2);
        balance.result();

        // Задание 3
        Bell bell = new Bell();
        bell.sound();
        bell.sound();
        bell.sound();

        // Задание 4
        OddEvenSeparator separator = new OddEvenSeparator();
        separator.addNumber(1);
        separator.addNumber(2);
        separator.addNumber(3);
        separator.addNumber(4);
        separator.even();
        separator.odd();

        // Задание 5
        Table table = new Table(3, 3);
        table.setValue(0, 0, 1);
        table.setValue(0, 1, 2);
        table.setValue(0, 2, 3);
        table.setValue(1, 0, 4);
        table.setValue(1, 1, 5);
        table.setValue(1, 2, 6);
        table.setValue(2, 0, 7);
        table.setValue(2, 1, 8);
        table.setValue(2, 2, 9);

        System.out.println(table);
        System.out.println("Average: " + table.average());
    }
}
// Задание 1
class Button
{
    private int clickCount;

    public Button()
    {
        clickCount = 0;
    }

    public void click()
    {
        clickCount++;
        System.out.println("Button was clicked " + clickCount + " times");
    }
}

// Задание 2
class Balance
{
    private int leftWeight;
    private int rightWeight;

    public Balance()
    {
        leftWeight = 0;
        rightWeight = 0;
    }

    public void addLeft(int weight)
    {
        leftWeight += weight;
    }

    public void addRight(int weight)
    {
        rightWeight += weight;
    }

    public void result()
    {
        if (leftWeight == rightWeight)
        {
            System.out.println("=");
        } else if (leftWeight > rightWeight)
        {
            System.out.println("L");
        } else
        {
            System.out.println("R");
        }
    }
}

// Задание 3
class Bell
{
    private boolean isDing;

    public Bell()
    {
        isDing = true;
    }

    public void sound()
    {
        if (isDing)
        {
            System.out.println("ding");
        } else
        {
            System.out.println("dong");
        }
        isDing = !isDing;
    }
}

// Задание 4
class OddEvenSeparator
{
    private List<Integer> numbers;

    public OddEvenSeparator()
    {
        numbers = new ArrayList<>();
    }

    public void addNumber(int number)
    {
        numbers.add(number);
    }

    public void even()
    {
        System.out.print("Even numbers: ");
        for (int number : numbers)
        {
            if (number % 2 == 0)
            {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    public void odd()
    {
        System.out.print("Odd numbers: ");
        for (int number : numbers)
        {
            if (number % 2 != 0)
            {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}

// Задание 5: Класс Table
class Table
{
    private int[][] table;

    public Table(int rows, int cols)
    {
        table = new int[rows][cols];
    }

    public int getValue(int row, int col)
    {
        return table[row][col];
    }

    public void setValue(int row, int col, int value)
    {
        table[row][col] = value;
    }

    public int rows()
    {
        return table.length;
    }

    public int cols()
    {
        return table[0].length;
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for (int[] row : table)
        {
            for (int val : row)
            {
                sb.append(val).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public double average()
    {
        int total = 0;
        int count = 0;
        for (int[] row : table)
        {
            for (int val : row)
            {
                total += val;
                count++;
            }
        }
        return (double) total / count;
    }
}