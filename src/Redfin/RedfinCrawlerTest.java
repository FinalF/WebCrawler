package Redfin;

import BasicCrawler.Spider;
import Redfin.util.GetConfig;

public class RedfinCrawlerTest {
    public static void main(String[] args) {
        //GetConfig.loadConfig();
        Spider spider = new RedfinSpider();
        spider.scrap("https://www.redfin.com/WA/Seattle/1141-A-N-94th-St-98103/home/147070700");
        //spider.scrap("https://www.zillow.com/seattle-wa/");
    }
}
