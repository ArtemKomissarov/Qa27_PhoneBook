package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example() {
        List<Object[]> list = new ArrayList<>();

        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactSuccess() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .phone("34343434343")
                .email("stark@gmil.com")
                .address("NY")
                .description("all fields")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .phone("56985642357")
                .email("stark111@gmil.com")
                .address("NY")
                .build()});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactWrongPhone() {
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("123")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("12356598523641587566659495")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("wwwwwwwwwwww")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("")
                .address("NY")
                .description("John")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .phone("$%*&)#%%%%%%%")
                .address("NY")
                .description("John")
                .build()});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();

        while (line != null) {
            String[] all = line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line=reader.readLine();
        }
        return list.iterator();
    }
}