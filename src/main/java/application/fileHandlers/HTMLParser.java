package application.fileHandlers;

import application.detailedSearch.CarSpec;
import application.detailedSearch.SearchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

public class HTMLParser {

    public static void main(String[] args) throws IOException {
        SearchService searchService = new SearchService();
        Map<String, String> mpa = searchService.getPagesOfSearch("https://www.otomoto.pl/osobowe/alfa-romeo/giulia/?search%5Bnew_used%5D=on");
        for (Map.Entry temp: mpa.entrySet()) {
            System.out.println(temp.getKey()+"+"+temp.getValue());
        }
    }
}
