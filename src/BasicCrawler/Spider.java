package BasicCrawler;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Spider {
    protected Set<String> pagesVisited = new HashSet<String>();
    protected List<String> pagesToVisit = new LinkedList<String>();

    protected String nextUrl() {
        if (pagesToVisit.size() == 0)
            return null;
        String nextUrl = pagesToVisit.remove(0);
        while (this.pagesVisited.contains(nextUrl)) {
            nextUrl = pagesToVisit.remove(0);
        }
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }
//    protected void searchKeyword(String url, String searchWord)
//    {
//
//        while (this.pagesVisited.size() < MAX_PAGES_TO_SEARCH ) {
//            String currentUrl;
//            SpiderLeg leg = new SpiderLegImp();
//            if (this.pagesToVisit.isEmpty()) {
//                currentUrl = url;
//                this.pagesVisited.add(url);
//            } else {
//                currentUrl = this.nextUrl();
//            }
//            leg.crawl(currentUrl);
//            boolean success = leg.searchForWord(searchWord);
//            if (success) {
//                System.out.println(String.format("**Success** Word %s found at %s", searchWord, currentUrl));
//                break;
//            }
//            this.pagesToVisit.addAll(leg.getLinks());
//        }
//
//        System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
//    }

    public abstract void scrap(String url);
}
