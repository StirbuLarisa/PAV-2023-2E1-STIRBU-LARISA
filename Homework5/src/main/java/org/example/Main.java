package org.example;
import java.util.*;


/*
add doc-2 Sample-3 path/to/document2 author=Ana,year=2022
load catalog.json
save catalog.json
list
view
report report.html
quit
*/
public class Main {
    public static void main(String[] args) throws Exception {
        Catalog catalog = new Catalog();


        Map<String, String> tags = new HashMap<>();
        tags.put("author", "Ben Dover");
        tags.put("year", "1944");
        catalog.addDocument("doc-1", "Document test", "G:\\Anul 2\\sem2",  tags);


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter command: ");
            String input = scanner.nextLine();
            String[] tokens = input.split("\\s+");  //unul sau mai multe whitespaces sunt separatori

            if (tokens[0].equals("add")) {
                Command command = new AddCommand();
                command.execute(catalog, Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (tokens[0].equals("load")) {
                Command command = new LoadCommand();
                command.execute(catalog, Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (tokens[0].equals("save")) {
                Command command = new SaveCommand();
                command.execute(catalog, Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (tokens[0].equals("list")) {
                Command command = new ListCommand();
                command.execute(catalog, Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (tokens[0].equals("view")) {
                Command command = new ViewCommand();
                command.execute(catalog, Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (tokens[0].equals("report")) {
                Command command = new ReportCommand();
                command.execute(catalog, Arrays.copyOfRange(tokens, 1, tokens.length));
            } else if (tokens[0].equals("quit")) {
                System.out.println("Exiting application...");
                break;
            } else {
                System.out.println("Invalid command, please try again");
            }
        }

        scanner.close();
    }
}
