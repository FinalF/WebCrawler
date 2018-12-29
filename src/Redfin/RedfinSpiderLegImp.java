package Redfin;

import BasicCrawler.SpiderLeg;
import Redfin.util.GetStats;
import org.jsoup.nodes.Document;

public class RedfinSpiderLegImp extends SpiderLeg{

    //TODO: Complete this method
    public boolean getPageWithFilter(String url){
        try {
            Document document = super.getHtmlDocument();
            //System.out.println(document.text());
            GetStats.setDocument(document);

            if(GetStats.getPrice()<0) return false;
            System.out.println("====");
            System.out.println("URL: " + url);
            System.out.println("Price: " + GetStats.getPrice());
            System.out.println("Address: " + GetStats.getAddr());
            System.out.println("Bed: " + GetStats.getBeds());
            System.out.println("Bath: " + GetStats.getBaths());
            System.out.println("Square Feet: " + GetStats.getSqt());
            System.out.println("Build Year: " + GetStats.getBuildYear());
            System.out.println("County: " + GetStats.getCounty());
            System.out.println("Community: " + GetStats.getCommunity());
            System.out.println("====");
            return true;
        }
        catch (Exception e){
            //System.out.println(e.getMessage());
            return false;
        }
    };
}
