package application.fileHandlers;

import application.detailedSearch.CarSpec;
import application.detailedSearch.SearchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTMLParser {


    public static void main(String[] args) throws IOException {
        SearchService service = new SearchService();
        CarSpec spec = new CarSpec("Citroen");
        spec.setModel("c4-picasso");
        String url = service.findCarBySpec(spec);
        System.out.println(url);
      // Document doc = Jsoup.connect("https://www.otomoto.pl/osobowe/acura/mdx/").get();

    }
}
