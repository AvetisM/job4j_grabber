package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;

public class HabrCareerParse {

    private static final String SOURCE_LINK = "http://career.habr.com";

    private static final String PAGE_TEMPLE = "%s/vacancies/java_developer?page=%s";

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 5; i++) {
            String pageLink = String.format(PAGE_TEMPLE, SOURCE_LINK, i);
            Connection connection = Jsoup.connect(pageLink);
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                String link = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                Element dateElement = row.select(".vacancy-card__date").first().child(0);
                String dateAttribute = dateElement.attr("datetime");
                LocalDateTime date = new HabrCareerDateTimeParser().parse(dateAttribute);
                String description = retrieveDescription(link);
                Post post = new Post(vacancyName, link, description, date);
                System.out.println(post.toString());
            });
        }
    }

    private static String retrieveDescription(String link) {
        StringBuffer stringBuffer = new StringBuffer();
        Connection connection = Jsoup.connect(link);
        try {
            Document document = connection.get();
            Elements rows = document.select(".job_show_description__vacancy_description");
            rows.forEach(row -> {
                Element descriptionElement = row.child(0);
                stringBuffer
                        .append(descriptionElement.text())
                        .append(System.lineSeparator());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
