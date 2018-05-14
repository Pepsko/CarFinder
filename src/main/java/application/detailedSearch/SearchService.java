package application.detailedSearch;

import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Service
public class SearchService {

    private  String filterEnum(String insert, String ... args){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <args.length ; i++) {
            sb.append("search%5Bfilter_enum_").append(insert).append("%5D%5B").append(i).append("%5D=").append(args[i]).append("&");
        }
        return sb.toString();
    }
    public String getSearchUrlBySpec(CarSpec spec){
        StringBuilder sb = new StringBuilder();
        sb.append("https://www.otomoto.pl/osobowe/").append(spec.getBrand()).append("/").append(spec.getModel()).append("/").append(spec.getBodyType()).append("/")
                .append("od-").append(spec.getProductionFrom()).append("/?search%5Bfilter_float_year%3Ato%5D=").append(spec.getProductionTo()).append("&")
                .append(filterFloat("mileage", spec.getMileageFrom(), spec.getMileageTo())).append(filterFloat("engine_power", spec.getPowerFrom(), spec.getPowerTo()))
                .append(filterEnum("transmission", spec.getDrivetrain())).append(filterEnum("color", spec.getColor()));
        return sb.toString();
    }
    private String filterFloat(String insert, String from, String to){
        String fromString="";
        String toString="";
        if(from!=null){
            fromString = from;
        }
        if(to!=null){
            toString = to;
        }
        return "search%5Bfilter_float_"+insert+"%3Afrom%5D="+fromString+"&search%5Bfilter_float_"+insert+"%3Ato%5D="+toString+"&";
    }
    public Map<String, String> collectCarOffers(Elements links){
        Map<String, String> offers = new TreeMap<>();
        for (Element temp: links) {
            //if(temp.attr("abs:href").contains("/oferta/"))
                offers.put(temp.attr("abs:href"), temp.attr("title"));
        }
        return offers;
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
}
