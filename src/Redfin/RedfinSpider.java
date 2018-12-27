package Redfin;

import BasicCrawler.Spider;
import BasicCrawler.SpiderLeg;
import BasicCrawler.SpiderLegImp;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class RedfinSpider extends Spider {
    private static final int MAX_PAGES_TO_SEARCH = 2;
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();


    @Override
    public void scrap(String url) {
        {

            while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH ) {
                String currentUrl;
                SpiderLeg leg = new SpiderLegImp();
                if (this.pagesToVisit.isEmpty()) {
                    currentUrl = url;
                    this.pagesVisited.add(url);
                } else {
                    currentUrl = this.nextUrl();
                }
                leg.crawl(currentUrl);
                boolean success = leg.getPageWithFilter();
                if (success) {
                    System.out.println(String.format("**Success** Word %s found at %s", currentUrl));
                    break;
                }
                this.pagesToVisit.addAll(leg.getLinks());
            }

            System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
        }
    }


}
