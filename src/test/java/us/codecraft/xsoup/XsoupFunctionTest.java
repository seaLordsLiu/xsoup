package us.codecraft.xsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 函数测试类
 * @author liu xw
 * @date 2023 07-10
 */
public class XsoupFunctionTest {

    private String html = "<html>" +
        "<body>" +
        " <div id='test'>aaa</div>" +
        " <div id='test2'>aaa" +
        "  <div>" +
        "   <a href=\"https://github.com\">github.com</a>" +
        "   <a href=\"https://github.com\">github.com</a>" +
        "   <a href=\"https://github2.com\">github2.com</a>" +
        "   <a href=\"https://github3.com\">github3.com</a>" +
        "  </div>" +
        " </div>" +
        "</body>" +
        "</html>";

    private String html2 = "<div id=\"info\" class=\"\">\n" +
            "\n" +
            "\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span>\n" +
            "      <span class=\"pl\"> 作者</span>:\n" +
            "        \n" +
            "            <a class=\"\" href=\"/author/4502506\">鲁迅</a>\n" +
            "    </span><br/>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span class=\"pl\">出版社:</span>\n" +
            "      <a href=\"https://book.douban.com/press/2526\">同心出版社</a>\n" +
            "    <br>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span class=\"pl\">出品方:</span>\n" +
            "      <a href=\"https://book.douban.com/producers/352\">万文社</a>\n" +
            "    <br>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span class=\"pl\">出版年:</span> 2014-5-1<br/>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span class=\"pl\">页数:</span> 7827<br/>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span class=\"pl\">定价:</span> 388.00元<br/>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    <span class=\"pl\">装帧:</span> 精装<br/>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "    \n" +
            "      \n" +
            "      <span class=\"pl\">ISBN:</span> 9787547711101<br/>\n" +
            "\n" +
            "    \n" +
            "    \n" +
            "  \n" +
            "\n" +
            "\n" +
            "</div>\n";

    /**
     * 包含测试
     */
    @Test
    public void contains$testOne(){
//        Document document = Jsoup.parse(html);
//        String result = Xsoup.compile("//a[contains(:text:one,'github2.com')]/@href").evaluate(document).get();
//        assertThat(result).isEqualTo("https://github2.com");
//        System.out.println(result);

        Document document2 = Jsoup.parse(html2);

        String s = Xsoup.compile("//div[@id='info']/span[contains(:text:one,'ISBN:')]/followingSiblingText()").evaluate(document2).get();
        System.out.println(s);

    }

    /**
     * 包含测试
     */
    @Test
    public void contains$testAll(){
        Document document = Jsoup.parse(html);
        List<String> list = Xsoup.compile("//a[contains(:text:all,'github')]/@href").evaluate(document).list();
        assertThat(list).hasSize(2);
        System.out.println(list);
    }

    /**
     * 包含测试
     */
    @Test
    public void contains$attribute(){
        Document document = Jsoup.parse(html);
        List<String> list = Xsoup.compile("//a[contains(:@href,'https://github.com')]/@href").evaluate(document).list();
        assertThat(list).hasSize(2);
        System.out.println(list);
    }

    /**
     * 包含测试
     */
    @Test
    public void contains$attributeNot(){
        Document document = Jsoup.parse(html);
        List<String> list = Xsoup.compile("//a[contains(:not:@href,'https://github.com')]/@href").evaluate(document).list();
        assertThat(list).hasSize(2);
        System.out.println(list);
    }

    /**
     * 包含测试
     */
    @Test
    public void contains$attributeStart(){
        Document document = Jsoup.parse(html);
        List<String> list = Xsoup.compile("//a[contains(:start:@href,'https://github2')]/@href").evaluate(document).list();
        assertThat(list).hasSize(1);
        System.out.println(list);

        List<String> list2 = Xsoup.compile("//a[contains(:start:@href,'https://github')]/@href").evaluate(document).list();
        assertThat(list2).hasSize(4);
        System.out.println(list2);
    }
}
