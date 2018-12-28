package Redfin;

import BasicCrawler.Spider;

public class RedfinCrawlerTest {
    public static void main(String[] args) {
        Spider spider = new RedfinSpider();
        spider.scrap("https://www.redfin.com/city/16163/WA/Seattle");
    }
}
