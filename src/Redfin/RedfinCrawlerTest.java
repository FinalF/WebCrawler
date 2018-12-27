package Redfin;

import BasicCrawler.Spider;

public class RedfinCrawlerTest {
    public static void main(String[] args) {
        Spider spider = new RedfinSpider();
        spider.scrap("https://www.redfin.com/WA/Seattle/7530-15th-Ave-NW-98117/home/50272964");
    }
}
