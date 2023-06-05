package org.example;

import org.htmlunit.html.HtmlPage;
import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TestParser testParser = new TestParser();
        List<String> tests = testParser.scrapeTests();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Соскраплено тестов: " + tests.size());

        while (true){
            System.out.println("ВВЕДИ ВОПРОС:");
            String text = scanner.nextLine();
            System.out.println();
            tests.stream()
                    .filter(test -> test.contains(text))
                    .forEach(test -> System.out.println(test +"\n"));
            System.out.println("\n");

        }
    }
}