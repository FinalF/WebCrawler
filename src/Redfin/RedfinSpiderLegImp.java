package Redfin;

import BasicCrawler.SpiderLeg;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class RedfinSpiderLegImp extends SpiderLeg{
    //TODO: Complete this method
    public boolean getPageWithFilter(){
        Document document = super.getHtmlDocument();
        //System.out.println(document.text());
        Elements resultLinks = document.select("div.statsValue");
        for(Element e : resultLinks){
            System.out.println(e.className() + " : " +e.text());
        }
        return true;
    };
}
