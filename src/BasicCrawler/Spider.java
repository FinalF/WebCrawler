package BasicCrawler;

import CrawlerInerfaces.ISpider;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class Spider implements ISpider {
    protected Set<String> pagesVisited = new HashSet<String>();
    protected List<String> pagesToVisit = new LinkedList<String>();

    public String nextUrl() {
        if (pagesToVisit.size() == 0)
            return null;
        String nextUrl = pagesToVisit.remove(0);
        while (this.pagesVisited.contains(nextUrl)) {
            nextUrl = pagesToVisit.remove(0);
        }
        this.pagesVisited.add(nextUrl);
        return nextUrl;
    }

    public abstract void scrap(String url);
}
