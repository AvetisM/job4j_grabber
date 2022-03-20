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

    public HabrCareerParse(DateTimeParser dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public void parse() {
        for (int i = 1; i <= 5; i++) {
            String pageLink = String.format(PAGE_TEMPLE, SOURCE_LINK, i);
            List<Post> postList = list(pageLink);
            postList.forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        HabrCareerParse habrCareerParse = new HabrCareerParse(new HabrCareerDateTimeParser());
        habrCareerParse.parse();
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

    @Override
    public List<Post> list(String link) {
        List<Post> rls = new ArrayList<>();
        try {
            Connection connection = Jsoup.connect(link);
            Document document = connection.get();
            Elements rows = document.select(".vacancy-card__inner");
            rows.forEach(row -> {
                Element titleElement = row.select(".vacancy-card__title").first();
                Element linkElement = titleElement.child(0);
                String vacancyName = titleElement.text();
                String vacancyLink = String.format("%s%s", SOURCE_LINK, linkElement.attr("href"));
                Element dateElement = row.select(".vacancy-card__date").first().child(0);
                String dateAttribute = dateElement.attr("datetime");
                LocalDateTime date = dateTimeParser.parse(dateAttribute);
                String description = retrieveDescription(vacancyLink);
                rls.add(new Post(vacancyName, vacancyLink, description, date));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rls;
    }
}
