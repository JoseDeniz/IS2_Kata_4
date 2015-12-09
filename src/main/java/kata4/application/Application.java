package kata4.application;

import kata4.model.Histogram;
import kata4.model.Mail;
import kata4.model.Person;
import kata4.view.process.HistogramBuilder;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.util.Arrays.stream;

public class Application {

    public static void main(String[] args) throws SQLException {
        Person[] people = new DatabasePersonLoader(createConnection("src/main/resources/people.db")).load();
        Histogram<String> histogram =  new HistogramBuilder<String>().build(extractDomains(people));

        new HistogramDisplay(histogram).display();
    }

    private static Connection createConnection(String dbPath) throws SQLException {
        DriverManager.registerDriver(new JDBC());
        return DriverManager.getConnection("jdbc:sqlite:" + dbPath);
    }

    private static String[] extractDomains(Person[] people) {
        return stream(people).map(Person::getMail)
                             .map(Mail::getDomain)
                             .toArray(String[]::new);
    }

}
