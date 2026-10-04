package utilities;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvTestDataReader {

    public static void main(String[] args) {

        String filePath =
                "src/test/resources/testdata/create-account.csv";

        try (BufferedReader reader =
                     new BufferedReader(new FileReader(filePath))) {

            String line;

            // Read header
            String header = reader.readLine();

            System.out.println("HEADER:");
            System.out.println(header);

            System.out.println("\nDATA:");

            while ((line = reader.readLine()) != null) {

                String[] columns = line.split(",");

                System.out.println(
                        "Scenario: " + columns[0]
                );

                System.out.println(
                        "Username: " + columns[1]
                );

                System.out.println(
                        "Password: " + columns[2]
                );

                System.out.println(
                        "Phone: " + columns[3]
                );

                System.out.println(
                        "Email: " + columns[4]
                );

                System.out.println(
                        "Expected Status: " + columns[5]
                );

                System.out.println("--------------------");
            }

        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}
