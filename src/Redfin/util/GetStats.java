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
     *
     * @return
     */
    public static double getPrice() {
        Elements priceBlock = document.select("div.info-block.price");
        //System.out.println(priceBlock);
        if (priceBlock.size() > 0) {
            Element e = priceBlock.first();
            return Double.parseDouble(e.text().substring(1).replace("Price", "").replace(",", ""));
        }
        return -1;
    }

    ;

    public static String getAddr() {
        Elements addrBlock = document.select("h1.address");
        if (addrBlock.size() > 0) {
            Element e = addrBlock.first();
            //System.out.println(pe.text());
            return e.text().replace(","," ");
        }
        return "[N/A] Address not captured";
    }

    ;

    public static double getBeds() {
        Elements homeStatsBlock = document.select("div.info-block");
        try {
            return Double.parseDouble(homeStatsBlock.select("[data-rf-test-id=\"abp-beds\"]").first().text().replace("Beds", "").replace("Bed", ""));
        } catch (Exception e) {
            return -1;
        }
    }

    public static double getBaths() {
        Elements homeStatsBlock = document.select("div.info-block");
        try {
            //System.out.println(homeStatsBlock.select("[data-rf-test-id=\"abp-baths\"]").first().text());
            return Double.parseDouble(homeStatsBlock.select("[data-rf-test-id=\"abp-baths\"]").first().text().replace("Baths", "").replace("Bath", ""));
        } catch (Exception e) {
            return -1;
        }
    }

    public static double getSqrt() {
        Elements homeStatsBlock = document.select("div.info-block");
        try {
            //System.out.println(homeStatsBlock.select("[data-rf-test-id=\"abp-sqFt\"]").first().select("span.statsValue").first().text().replace(",", ""));
            return Double.parseDouble(homeStatsBlock.select("[data-rf-test-id=\"abp-sqFt\"]").first().select("span.statsValue").first().text().replace(",", ""));
        } catch (Exception e) {
            return -1;
        }
    }


    public static double getBuildYear() {
        Elements keyDetailStatsBlock = document.select("div.keyDetail");
        for (Element el : keyDetailStatsBlock) {
            String stat = el.text();
            if (stat.contains("Built")) {
                try {
                    return Double.parseDouble(stat.replace("Built", ""));
                } catch (Exception e) {
                    return -1;
                }
            }
        }
        return -1;
    }

    public static String getCounty() {
        Elements keyDetailStatsBlock = document.select("div.keyDetail");
        for (Element el : keyDetailStatsBlock) {
            String stat = el.text();
            if (stat.contains("County")) {
                return stat.replace("County", "");

            }
        }
        return "[N/A] County not captured";
    }
    public static String getCommunity() {
        Elements keyDetailStatsBlock = document.select("div.keyDetail");
        for (Element el : keyDetailStatsBlock) {
            String stat = el.text();
            if (stat.contains("Community")) {
                return stat.replace("Community", "");

            }
        }
        return "[N/A] Community not captured";
    }
}