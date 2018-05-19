package application.detailedSearch;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;
import java.util.*;

public class OfferDisplayService {
    private Document offersPage;

    public OfferDisplayService(String offer) throws IOException {
        this.offersPage = Jsoup.connect(offer).get();
    }

    public String getOffersPrice() {
        Elements divs = offersPage.select("div[class=offer-price]");
        return divs.attr("data-price");
    }
    public List<String> getCarFeatures(){
        List<String> features = new LinkedList<>();
        Elements li = offersPage.select("li[class=offer-features__item]");
        for (Element temp:li) {
            features.add(temp.text());
        }
        return features;
    }
    public List<String> getFullDescription(){
        List<String> lines = new LinkedList<>();
        Elements links = offersPage.select("div[class=offer-description][id=description]");
        String string = links.select("div[data-read-more]").toString();
        String substring = string.substring(string.indexOf(">")+1);
        String[] brs = substring.split("<br>");
        List<String> br = new LinkedList<>();
        for (int i =0; i <brs.length-1 ; i++) {
            br.add(brs[i]);
        }
        return lines;
    }
    public Map<String, String> getCarParameters(){
        Map<String, String> params = new TreeMap<>();
        Elements links = offersPage.select("div[id=parameters]");
        Elements keys = links.select("span[class=offer-params__label]");
        Elements values = links.select("div[class=offer-params__value]");
        for (int i = 0; i <values.size() ; i++) {
            params.put(keys.get(i).text(), values.get(i).text());
        }
        return params;
    }
    public Map<String, String> getMainCarPhotosWithThumbs(){
        Map<String, String> photos = new HashMap<>();
        Elements tags = offersPage.select("div[offer-photos-thumbs]");
        tags = tags.select("a[href]");
        for (Element tag: tags) {
            photos.put(tag.attr("data-thumb"),tag.attr("href"));
        }
        return photos;
    }
    public Set<String> getAllCarPhotos(){
        Set<String> photos = new HashSet<>();
        Elements tags = offersPage.select("div[class=photo-item]");
        tags = tags.select("img[class]");
        for (Element tag: tags) {
            photos.add(tag.attr("src"));
        }
        return photos;
    }

}
