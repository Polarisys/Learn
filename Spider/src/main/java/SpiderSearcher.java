import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

/**
 * @anthor Tolaris
 * @date 2020/3/4 - 21:29
 */
public class SpiderSearcher {
    public static void main(String[] args) {
        //设置webdriver路径
        System.setProperty("webdriver.chrome.driver", SpiderSearcher.class.getClassLoader().getResource("chromedriver.exe").getPath());
        //创建webdriver
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://www.lagou.com/zhaopin/Java/?labelWords=label");
        //通过xpath选中元素
        clickOption(webDriver, "工作经验", "应届毕业生");
        clickOption(webDriver, "学历要求", "本科");
        clickOption(webDriver, "融资阶段", "B轮");
        clickOption(webDriver, "公司规模", "不限");
        clickOption(webDriver, "行业领域", "移动互联网");

        //解析页面元素
        ElementPagination(webDriver);
    }

    private static void ElementPagination(WebDriver webDriver) {
        List<WebElement> elements = webDriver.findElements(By.className("con_list_item"));
        for (WebElement element : elements) {
            String companyName = element.findElement(By.className("company_name")).getText();
            WebElement moneyElement = element.findElement(By.className("position")).findElement(By.className("money"));
            System.out.println(companyName + ":" + moneyElement.getText());
        }
        WebElement pagerNext = webDriver.findElement(By.className("pager_next"));
        if (!pagerNext.getAttribute("class").contains("pager_next_disabled")) {
            pagerNext.click();
            System.out.println("下一页");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ElementPagination(webDriver);
        }
    }

    private static void clickOption(WebDriver webDriver, String choseTitle, String optionTitle) {
        WebElement choseElement = webDriver.findElement(By.xpath("//li[@class='multi-chosen']//span[contains(text(),'" + choseTitle + "')]"));
        WebElement optionElement = choseElement.findElement(By.xpath("../a[contains(text(),'" + optionTitle + "')]"));
        optionElement.click();
    }
}
