import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.net.URL;

/**
 * @anthor Tolaris
 * @date 2020/3/6 - 15:39
 */
public class JsoupTest {
    public static void main(String[] args) throws Exception {
        Document document = Jsoup.parse(new URL("http://www.itcast.cn"), 3000);
        Element select = document.select("h3#city_bj").first();
        System.out.println(select.text());
    }
}
