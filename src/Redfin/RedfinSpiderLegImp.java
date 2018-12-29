package Redfin;

import BasicCrawler.SpiderLeg;
import Redfin.util.DBTool;
import Redfin.util.GetStats;
import org.jsoup.nodes.Document;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RedfinSpiderLegImp extends SpiderLeg {

    //TODO: Complete this method
    public boolean getPageWithFilter(String url, Map<String, Double> config) {
        try {
            Document document = super.getHtmlDocument();
            //System.out.println(document.head());
            GetStats.setDocument(document);
//            System.out.println("====");
//            System.out.println("URL: " + url);
//            System.out.println("Price: " + GetStats.getPrice());
//            System.out.println("Address: " + GetStats.getAddr());
//            System.out.println("Bed: " + GetStats.getBeds());
//            System.out.println("Bath: " + GetStats.getBaths());
//            System.out.println("Square Feet: " + GetStats.getSqrt());
//            System.out.println("Build Year: " + GetStats.getBuildYear());
//            System.out.println("County: " + GetStats.getCounty());
//            System.out.println("Community: " + GetStats.getCommunity());
//            System.out.println("====");
            if(!url.contains("home")) return false;
            double price = GetStats.getPrice();
            if (price > config.get("Price")) return false;
            double bed = GetStats.getBeds();
            if (bed < config.get("Bed")) return false;
            double bath = GetStats.getBaths();
            if (bath < config.get("Bath")) return false;
            double sqrt = GetStats.getSqrt();
            if (sqrt < config.get("Square Feet")) return false;
            double year = GetStats.getBuildYear();
            if (year < config.get("Build Year")) return false;
            String addr = GetStats.getAddr();
            String county = GetStats.getCounty();
            String community = GetStats.getCommunity();
            List<String> list = new ArrayList<>();
            list.add(Double.toString(price));
            list.add(Double.toString(bed));
            list.add(Double.toString(bath));
            list.add(Double.toString(sqrt));
            list.add(Integer.toString((int)year));
            list.add(addr);
            list.add(community);
            list.add(county);
            list.add(url);
            DBTool.writeToFile("/Users/flame/JAVA/WebCrawler/src/Redfin/output/", list);

            return true;
        } catch (Exception e) {
            //System.out.println(e.getMessage());
            return false;
        }
    }

    ;
}
