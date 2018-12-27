package BasicCrawler;

public class CrawlerTest {
    public static void main(String[] args) {
        Spider spider = new Spider();
        spider.search("https://www.redfin.com/zipcode/98107", "1551003");
    }
}
