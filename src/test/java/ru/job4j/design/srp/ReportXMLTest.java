package ru.job4j.design.srp;

import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ReportXMLTest {
    @Test
    public void whenXmlGenerated() throws Exception {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        String expect = "";
        JAXBContext context = JAXBContext.newInstance(Employee.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(worker, writer);
            expect = writer.getBuffer().toString();
        }
        Report reportXML = new ReportXML(store);
        assertThat(reportXML.generate(em -> true), is(expect));
    }
}