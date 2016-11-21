package com.piggsoft;

import cn.edu.hfut.dmic.webcollector.model.Links;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.crawler.BreadthCrawler;
import org.jsoup.nodes.Document;

import java.util.regex.Pattern;

public class TutorialCrawler extends BreadthCrawler {

    public TutorialCrawler(String crawlPath, boolean autoParse) {
        super(crawlPath, autoParse);
        /*start page*/
        this.addSeed("http://blog.csdn.net/");

        /*fetch url like http://news.yahoo.com/xxxxx*/
        this.addRegex("http://blog.csdn.net/.*/article/details/.*");
        /*do not fetch url like http://news.yahoo.com/xxxx/xxx)*/
        this.addRegex("-http://news.yahoo.com/.+/.*");
        /*do not fetch jpg|png|gif*/
        this.addRegex("-.*\\.(jpg|png|gif).*");
        /*do not fetch url contains #*/
        this.addRegex("-.*#.*");
    }

    @Override
    public void visit(Page page, Links links) {
        String url = page.getUrl();
        if (Pattern.matches("http://blog.csdn.net/.*/article/details/.*", url)) {
            Document doc = page.getDoc();
            String title = doc.select("div[class=article_title]").first().text();
            String author = doc.select("div[id=blog_userface]").first().text();
            System.out.println("title:" + title + "\tauthor:" + author);
        }
    }

    /*
        可以往next中添加希望后续爬取的任务，任务可以是URL或者CrawlDatum
        爬虫不会重复爬取任务，从2.20版之后，爬虫根据CrawlDatum的key去重，而不是URL
        因此如果希望重复爬取某个URL，只要将CrawlDatum的key设置为一个历史中不存在的值即可
        例如增量爬取，可以使用 爬取时间+URL作为key。

        新版本中，可以直接通过 page.select(css选择器)方法来抽取网页中的信息，等价于
        page.getDoc().select(css选择器)方法，page.getDoc()获取到的是Jsoup中的
        Document对象，细节请参考Jsoup教程
    */
    public static void main(String[] args) throws Exception {
        TutorialCrawler crawler = new TutorialCrawler("crawler", true);
        crawler.addSeed("http://blog.csdn.net/.*");
        crawler.addRegex("http://blog.csdn.net/.*/article/details/.*");

        /*可以设置每个线程visit的间隔，这里是毫秒*/
        //crawler.setVisitInterval(1000);
        /*可以设置http请求重试的间隔，这里是毫秒*/
        //crawler.setRetryInterval(1000);

        crawler.setThreads(30);
        crawler.start(2);
    }

}