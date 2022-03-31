package ru.job4j.grabber;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.grabber.utils.DateTimeParser;
import ru.job4j.grabber.utils.HabrCareerDateTimeParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HabrCareerParse implements Parse {

    private final DateTimeParser dateTimeParser;
    private static final String SOURCE_LINK = "http://career.habr.com";
    private static final String PAGE_TEMPLE = "%s/vacancies/java_developer?page=%s";
    private static final int PAGE_COUNT = 5;

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public  List<Post> parse() {
        List<Post> postList = list(SOURCE_LINK);
        return postList;
    }

    public static void main(String[] args) {
        HabrCareerParse habrCareerParse = new HabrCareerParse(new HabrCareerDateTimeParser());
        habrCareerParse.parse();
    }

    private static String retrieveDescription(String link) {
        StringBuilder stringBuilder = new StringBuilder();
        Connection connection = Jsoup.connect(link);
        try {
            Document document = connection.get();
            Elements rows = document.select(".job_show_description__vacancy_description");
            rows.forEach(row -> {
                Element descriptionElement = row.child(0);
                stringBuilder
                        .append(descriptionElement.text())
                        .append(System.lineSeparator());
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private Post retrievePost(Element row) {
        Element titleElement = row.select(".vacancy-card__title").first();
        Element linkElement = titleElement.child(0);
        String vacancyName = titleElement.text();
        String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
        Element dateElement = row.select(".vacancy-card__date").first().child(0);
        String dateAttribute = dateElement.attr("datetime");
        LocalDateTime date = dateTimeParser.parse(dateAttribute);
        String description = retrieveDescription(vacancyLink);
        return new Post(vacancyName, vacancyLink, description, date);
    }

    @Override
    public List<Post> list(String link) {
        List<Post> rls = new ArrayList<>();
        try {
            for (int i = 1; i <= PAGE_COUNT; i++) {
                String pageLink = String.format(PAGE_TEMPLE, link, i);
                Connection connection = Jsoup.connect(pageLink);
                Document document = connection.get();
                Elements rows = document.select(".vacancy-card__inner");
                rows.forEach(row -> rls.add(retrievePost(row)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rls;
    }
}
