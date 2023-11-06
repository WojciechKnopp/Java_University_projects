package pl.edu.ug.wknopp.javae.lab03.zadanieAPI.service;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import pl.edu.ug.wknopp.javae.lab03.zadanieAPI.domain.Person;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@ImportResource("classpath:beans.xml")
@Configuration
public class Data implements ApplicationContextAware {

    private static ApplicationContext ac;

    Data(){
        System.out.println("Data object created");
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        ac = applicationContext;
    }
    private static String sendGet(String url) throws IOException {
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

    @Bean
    public static List<Person> parseData(){
        String url = "https://stepik.org/media/attachments/lesson/266646/MOCK_DATA.csv";

        try {
            String data = Data.sendGet(url);

            ArrayList<Person> people = new ArrayList<>();
            Reader in = new StringReader(data);
            CSVFormat.Builder builder = CSVFormat.DEFAULT.builder().setHeader().setSkipHeaderRecord(true);
            Iterable<CSVRecord> records = builder.build().parse(in);
            for (CSVRecord record : records) {
                String id = record.get("id");
                Person person;
                if (Integer.parseInt(id) == 1)
                    person = ac.getBean("person0", Person.class);
                else if (Integer.parseInt(id) == 2) {
                    PersonManagerService personManagerService = ac.getBean(PersonManagerService.class);
                    person = personManagerService.getExamplePerson();
                } else {
                    person = ac.getBean("newPerson", Person.class);
                }

                person.setId(id);
                person.setFirstName(record.get("first_name"));
                person.setLastName(record.get("last_name"));
                person.setEmail(record.get("email"));
                person.setCompanyName(record.get("company_name"));
                people.add(person);
            }
            return people;
        } catch (IOException e) {
            System.out.println("Could not connect to website");
            return null;
        }
    }
}
