package application.detailedSearch;

import application.fileHandlers.OtomotoUrlParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SearchService {
    private final OtomotoUrlParser parser;

    public SearchService() {
        this.parser = new OtomotoUrlParser();
    }

    private Document getHtmlDoc(CarSpec spec) throws IOException {
        return Jsoup.connect(parser.getSearchUrlBySpec(spec)).get();
    }
    public Elements getOffersLinks(CarSpec spec) throws IOException {
        Document doc =getHtmlDoc(spec);
        return doc.select("a[href][title][style]");
    }
    public Elements getOffersLinks(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.select("a[href][title][style]");
    }
    public Map<String, String> getPagesOfSearch(CarSpec spec) throws IOException {
        return getPagesOfSearch(parser.getSearchUrlBySpec(spec));
    }
    public Map<String, String> getPagesOfSearch(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        Elements tags = doc.select("ul[class=om-pager rel]");
        tags = tags.select("a[href]");
        Map<String, String> pages = new HashMap<>();
        for (Element tag : tags) {
            String temp = tag.text();
            pages.put(temp, tag.attr("href"));
        }
        return pages;
    }

    public Map<String, String> mapOffersImages(Elements links){
        Map<String, String> images = new HashMap<>();
        for (Element temp:links) {
            String url = temp.attr("style");
            url = url.substring(url.indexOf("http"), url.indexOf("')"));
            images.put(temp.attr("abs:href"), url);
        }
        return images;
    }
    public Map<String, String> collectCarOffers(Elements links){
        Map<String, String> offers = new TreeMap<>();
        for (Element temp: links) {
            offers.put(temp.attr("abs:href"), temp.attr("title"));
        }
        return offers;
    }

}
