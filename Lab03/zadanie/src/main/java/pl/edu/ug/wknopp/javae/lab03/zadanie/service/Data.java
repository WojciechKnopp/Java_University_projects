package pl.edu.ug.wknopp.javae.lab03.zadanie.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.wknopp.javae.lab03.zadanie.domain.Person;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedHashMap;

@ImportResource("classpath:beans.xml")
public class Data {
    Data(){
        System.out.println("Data object created");
    }
    public static String sendGet(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        CloseableHttpResponse httpResponse = httpClient.execute(request);

        try{
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                return EntityUtils.toString(entity);
            }
        } finally {
            httpResponse.close();
            httpClient.close();
        }
        return null;
    }

    public static LinkedHashMap<String, Person> parseData(String data, ApplicationContext applicationContext) throws IOException {
        LinkedHashMap<String, Person> people = new LinkedHashMap<>();
        Reader in = new StringReader(data);
        CSVFormat.Builder builder = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true);
        Iterable<CSVRecord> records = builder.build().parse(in);
        for (CSVRecord record : records) {
            String id = record.get("id");
            Person person;
            if(Integer.parseInt(id) < 11)
                person = applicationContext.getBean("person"+id, Person.class);
            else if (Integer.parseInt(id) < 21)
                person = applicationContext.getBean("newPerson", Person.class);
            else{
                PersonManagerService personManagerService = applicationContext.getBean(PersonManagerService.class);
                person = personManagerService.getExamplePerson();
            }

            person.setFirstName(record.get("first_name"));
            person.setLastName(record.get("last_name"));
            person.setEmail(record.get("email"));
            person.setCompanyName(record.get("company_name"));
            people.put(id, person);
        }
        return people;
    }
}
