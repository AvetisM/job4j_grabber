package ru.job4j.design.srp;

import org.junit.Test;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXMLTest {
    @Test
    public void whenXmlGenerated() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss X");
        String dateString = formatter.format(now.getTime());
        Report reportXML = new ReportXML(store);
        String employeeXmlTemplate =
                "<employee name=\"%s\" hired=\"%s\" fired=\"%s\" salary=\"%.1f\"/>";
        StringBuilder expect = new StringBuilder()
         .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>")
                .append(String.format(Locale.US, employeeXmlTemplate,
                        worker.getName(), dateString, dateString, worker.getSalary()))
                .append("</employees>");
        String result = reportXML.generate(em -> true).replaceAll("\\n\\s*", "");
        assertThat(result, is(expect.toString()));
    }
}