import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.net.URL;

public class Test2 {
    public static void main(String[] args) {
        try{
            String url = "https://product.auto.163.com/new_daquan/brand/1685.html";
            Document document = Jsoup.parse(new URL(url).openStream(), "GBK", url);
            Element Items1 = document.getElementById("1685");
            System.out.println(Items1);
            Elements Items2 = Items1.select(".carList");
            System.out.println(Items2.size());

            Elements Items3 = Items2.select(".chexi_name");
            System.out.println("这是多少个厂商"+Items3.size());
            for (int i = 0; i < Items3.size(); i++) {
                Elements Items4 = Items3.get(i).select("a");
                String factoryURL = "https://product.auto.163.com"+Items4.attr("href");
                String factoryId = Items4.attr("id");
                String factoryName = Items4.attr("title");
                System.out.println(factoryName);
                System.out.println(factoryId);
                System.out.println(factoryURL);
            }
            //https://product.auto.163.com/new_daquan/factory/20257.html
            //getElementById(id)
           // Element Items1 = document.getElementById(id)

        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}
