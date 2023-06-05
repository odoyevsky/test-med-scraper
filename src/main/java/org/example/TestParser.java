package org.example;

import org.htmlunit.WebClient;
import org.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestParser {
    private WebClient webClient;
    private String url = "https://doctrina.space/subjects/biochemistry/tests_";

    public List<String> scrapeTests() {
        List<String> tests = new ArrayList<>();

        for (int i = 1; i < 19; i++) {
            HtmlPage page = getPage(url + i);

            tests.addAll(Arrays.stream(page.getElementsByTagName("div").get(4).getTextContent()
                            .replace("\n\n", " ")
                            .replace("   ", "\n")
                            .split("\n"))
                    .toList());
        }

        return tests;
    }

    public TestParser() {
        webClient = WebClientParser.webClient();
    }

    public HtmlPage getPage(String url) {
        try {
            return webClient.getPage(url);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
