import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import java.util.LinkedHashMap;
import java.util.Map;

public class StaticCurrencyScraper {

    public static void main(String[] args) {
        Map<String, String[]> currencies = new LinkedHashMap<>();
        currencies.put("Saat, Tarih ve Lokasyon", new String[] { "https://www.google.com/search?q=google+time+and+date",
        "div.vk_gy.vk_sh.card-section.sL6Rbf > div.gsrt.vk_bk.FzvWSb.YwPhnf, div.vk_gy.vk_sh.card-section.sL6Rbf > div.vk_gy.vk_sh > span.KfQeJ, div.vk_gy.vk_sh.card-section.sL6Rbf > span.vk_gy.vk_sh" });
        currencies.put("EUR/USD", new String[] { "https://www.google.com/search?q=1+eur+usd", ".SwHCTb" });
        currencies.put("USD/TRY", new String[] { "https://www.google.com/search?q=1+usd+try", ".SwHCTb" });
        currencies.put("EUR/TRY", new String[] { "https://www.google.com/search?q=1+eur+try", ".SwHCTb" });
        currencies.put("GBP/TRY", new String[] { "https://www.google.com/search?q=1+gbp+try", ".SwHCTb" });
        currencies.put("BTC/USD", new String[] { "https://www.google.com/search?q=1+btc+usd", ".pclqee" });
        currencies.put("ETH/USD", new String[] { "https://www.google.com/search?q=1+eth+usd", ".pclqee" });
        currencies.put("BTC/TRY", new String[] { "https://www.google.com/search?q=1+btc+try", ".pclqee" });
        currencies.put("ETH/TRY", new String[] { "https://www.google.com/search?q=1+eth+try", ".pclqee" });

        for (Map.Entry<String, String[]> entry : currencies.entrySet()) {
            String name = entry.getKey();
            String[] urlAndSelector = entry.getValue();
            String url = urlAndSelector[0];
            String selector = urlAndSelector[1];
            scraper(name, url, selector);
        }
    }

    private static void scraper(String name, String url, String selector) {
        try {
            Document document = Jsoup.connect(url).get();
            Elements elements = document.select(selector);
            System.out.println(name + " = " + elements.text());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
