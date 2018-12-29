package Redfin;

import BasicCrawler.Spider;
import BasicCrawler.SpiderLeg;
import Redfin.util.GetConfig;

import java.util.Map;


public class RedfinSpider extends Spider {
    private static final int MAX_PAGES_TO_SEARCH = 1000;
    private static final Map<String, Double> config = GetConfig.loadConfig();
    @Override
    public String nextUrl() {
        if (pagesToVisit.size() == 0)
            return null;
        String nextUrl = pagesToVisit.remove(0);
        while (this.pagesVisited.contains(nextUrl) || this.pagesVisited.contains(nextUrl.split("#")[0])) {
            nextUrl = pagesToVisit.remove(0);
        }
        this.pagesVisited.add(nextUrl);
        this.pagesVisited.add(nextUrl.split("#")[0]);
        return nextUrl;
    }

    @Override
    public void scrap(String url) {

            while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH) {
                String currentUrl;
                SpiderLeg leg = new RedfinSpiderLegImp();
                if (this.pagesToVisit.isEmpty()) {
                    currentUrl = url;
                    if(!this.pagesVisited.add(url)){
                        System.out.println("No new links. Terminate!");
                        break;
                    }
                } else {
                    currentUrl = this.nextUrl();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                leg.crawl(currentUrl);
                leg.getPageWithFilter(currentUrl, config);
                this.pagesToVisit.addAll(leg.getLinks());
            }
            System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));

    }


}
