package CrawlerInerfaces;

public interface ISpider {

    String nextUrl();
    void scrap(String url);

}
