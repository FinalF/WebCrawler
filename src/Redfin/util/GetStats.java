package Redfin.util;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class GetStats {
    private static Document document;

    public static void setDocument(Document doc) {
        document = doc;
        //System.out.println("Document set: "+document);
    }

    /**
     * get price of active list
     * @return
     */
    public static long getPrice() {
        Elements priceBlock = document.select("div.info-block.price");
        //System.out.println(priceBlock);
        if (priceBlock.size() > 0) {
            Element e = priceBlock.first();
            return Long.parseLong(e.text().substring(1).replace("Price", "").replace(",", ""));
        }
        return -1;
    }

    ;

    public static String getAddr() {
        Elements addrBlock = document.select("h1.address");
        if (addrBlock.size() > 0) {
            Element e = addrBlock.first();
            //System.out.println(pe.text());
            return e.text();
        }
        return "[N/A] Address not captured";
    }

    ;

    public static double getBeds() {
        Elements homeStatsBlock = document.select("div.info-block");
        try {
            return Double.parseDouble(homeStatsBlock.select("[data-rf-test-id=\"abp-beds\"]").first().text().replace("Beds", "").replace("Bed", ""));
        }
        catch(Exception e){
            return -1;
        }
    }

    public static double getBaths() {
        Elements homeStatsBlock = document.select("div.info-block");
        try {
            //System.out.println(homeStatsBlock.select("[data-rf-test-id=\"abp-baths\"]").first().text());
            return Double.parseDouble(homeStatsBlock.select("[data-rf-test-id=\"abp-baths\"]").first().text().replace("Baths", "").replace("Bath", ""));
        }
        catch(Exception e){
            return -1;
        }
    }

    public static double getSqt() {
        Elements homeStatsBlock = document.select("div.info-block");
        try {
            //System.out.println(homeStatsBlock.select("[data-rf-test-id=\"abp-sqFt\"]").first().select("span.statsValue").first().text().replace(",", ""));
            return Double.parseDouble(homeStatsBlock.select("[data-rf-test-id=\"abp-sqFt\"]").first().select("span.statsValue").first().text().replace(",", ""));
        }
        catch(Exception e){
            return -1;
        }
    }
}