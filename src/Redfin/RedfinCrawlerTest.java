package Redfin;

import BasicCrawler.Spider;
import Redfin.util.GetConfig;

public class RedfinCrawlerTest {
    public static void main(String[] args) {
        //GetConfig.loadConfig();
        Spider spider = new RedfinSpider();
        spider.scrap("https://www.redfin.com/WA/Mountlake-Terrace/21317-48th-Ave-W-98043/unit-E8/home/147501655");
        //spider.scrap("https://www.zillow.com/seattle-wa/");
    }
}
