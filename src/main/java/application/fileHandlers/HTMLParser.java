package application.fileHandlers;

import application.detailedSearch.CarSpec;
import application.detailedSearch.SearchService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HTMLParser {

    public static Elements getOffersLinksFromUrl(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.select("a[href][title][style]");
    }


    public static void main(String[] args) throws IOException {
       /* SearchService service = new SearchService();
        CarSpec spec = new CarSpec("bmw");
        spec.setModel("x6");
        String url = service.getSearchUrlBySpec(spec);
        System.out.println(url);*/
       Document doc = Jsoup.connect("https://www.otomoto.pl/oferta/bmw-x6-3-0d236kmrelingbi-xenonbialaalu-20-full-ID6zWpKB.html#20ed6d85fd").get();
       Elements links = doc.select("div[id=parameters]");
       Elements keys = links.select("span[class=offer-params__label]");
       Elements values = links.select("div[class=offer-params__value]");
        Map<String, String> params = new TreeMap<>();
        for (int i = 0; i <values.size() ; i++) {
            params.put(keys.get(i).text(), values.get(i).text());
        }

    }
}
