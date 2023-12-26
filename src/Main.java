import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Customer> lst = new ArrayList<Customer>();
        try {
            FileInputStream fstream = new FileInputStream("Clients.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader buffer = new BufferedReader(new InputStreamReader(in));
            String str = "";
            str = buffer.readLine();
            while ((str = buffer.readLine()) != null) {
                String[] arr = str.split(" ");
                lst.add(new Customer(arr[0], arr[1], Integer.parseInt(arr[2]), Integer.parseInt(arr[3])));
            }
            in.close();

        } catch (Exception e) {
            System.out.println("Text File could not be opened! " + e.getMessage());
        }

        int choice = -1;
        Scanner myChoice = new Scanner(System.in);
        // System.out.print("Please enter your choice: ");
        // choice = myChoice.nextInt();
        System.out.println("Welcome!, Please select one of the options below");
        while (choice != 5) {
            System.out.println(
                    "1. Find the average balance among customers\n2. Find the sum balance of all customers\n3. Search balance by name\n4. Shows a list of customers\n5. Exit");
            System.out.print("Please enter your choice: ");
            choice = myChoice.nextInt();
            myChoice.nextLine();
            if (choice == 1) {
                Double avg = lst.stream().mapToDouble(x -> x.getBalance()).average().orElse(0);
                System.out.println(avg);
            } else if (choice == 2) {
                double total = lst.stream().mapToInt(x -> x.getBalance()).sum();
                System.out.println(total);

            } else if (choice == 3) {
                System.out.print("Please enter their first name: ");
                String name = myChoice.nextLine();

                Optional<Customer> cr = lst.stream().filter(x -> x.getFname().equals(name)).findFirst();
                Customer c = cr.get();

                System.out.println(c.getFname() + " " + c.getLname() + " " + c.getAge() + " " + c.getBalance());

            }

            else if (choice == 4) {
                lst.forEach(
                        x -> System.out
                                .println(x.getFname() + " " + x.getLname() + " " + x.getAge() + " " + x.getBalance()));
            } else {
                if (choice != 5) {
                    System.out.println("Wrong option, Please try again");
                }
            }
        }

        System.out.println("Have a nice day!");

        myChoice.close();

    }
}