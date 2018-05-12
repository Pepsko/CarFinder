package application.fileHandlers;

import application.detailedSearch.CarSpec;
import application.detailedSearch.SearchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class HTMLParser {

    public static Elements getLinksFromUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements links = doc.select("a[href][title][style]");
        return links;
    }


    public static void main(String[] args) throws IOException {
       /* SearchService service = new SearchService();
        CarSpec spec = new CarSpec("bmw");
        spec.setModel("x6");
        String url = service.getSearchUrlBySpec(spec);
        System.out.println(url);*/
       Document doc = Jsoup.connect("https://www.otomoto.pl/osobowe/acura/mdx/").get();
       Elements links = doc.select("a[href][title][style]");
        for (Element temp: links) {
          //  if(temp.attr("abs:href").contains("/oferta/"))
            String url = temp.attr("style");
            url = url.substring(url.indexOf("http"), url.indexOf("')"));
            System.out.println(url);
        }

    }
}
