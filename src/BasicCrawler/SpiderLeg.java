package BasicCrawler;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public abstract class SpiderLeg {
    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;


    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page. Perform a searchForWord after the successful crawl
     *
     * @param url - The URL to visit
     * @return whether or not the crawl was successful
     */
    public boolean crawl(String url) {
        try {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT).timeout(180000).followRedirects(true);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;
            //System.out.println(this.htmlDocument);//get doc for testing
            if (connection.response().statusCode() != 200) // 200 is the HTTP OK status code
            {
                //System.out.println("\n**Visiting** Received web page at " + url);
                File input = new File("redfinPage1.html");
                this.htmlDocument = Jsoup.parse(input, "UTF-8");

            }
            if (!connection.response().contentType().contains("text/html")) {
                System.out.println("**Failure** Retrieved something other than HTML");
                return false;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
            System.out.println("\n**Visiting** Received web page at " + url + ". Found (" + linksOnPage.size() + ") links");
            for (Element link : linksOnPage) {
                this.links.add(link.absUrl("href"));
            }
            return true;
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe.getMessage());
            File input = new File("/Users/flame/JAVA/WebCrawler/src/Redfin/configurations/redfinPage1.html");
            try {
                this.htmlDocument = Jsoup.parse(input, "UTF-8");
               // System.out.println(this.htmlDocument.title());
            } catch (IOException e) {
                e.printStackTrace();
            }
            ioe.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }


    /**
     * Performs a search on the body of on the HTML document that is retrieved. This method should
     * only be called after a successful crawl.
     *
     * @param searchWord - The word or string to look for
     * @return whether or not the word was found
     */
    public boolean searchForWord(String searchWord) {
        // Defensive coding. This method should only be used after a successful crawl.
        if (this.htmlDocument == null) {
            System.out.println("ERROR! Call crawl() before performing analysis on the document");
            return false;
        }
        System.out.println("Searching for the word " + searchWord + "...");
        String bodyText = this.htmlDocument.body().text();
        return bodyText.toLowerCase().contains(searchWord.toLowerCase());
    }

    public abstract boolean getPageWithFilter(String url, Map<String, Double> config);

    public List<String> getLinks() {
        return this.links;
    }

    public Document getHtmlDocument() {
        return this.htmlDocument;
    }

}
