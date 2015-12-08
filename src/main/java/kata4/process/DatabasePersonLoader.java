package kata4.process;

import kata4.model.Mail;
import kata4.model.Person;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabasePersonLoader implements Loader {

    private final Connection connection;

    public DatabasePersonLoader(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Person[] load(){
        try {
            return processPeople(connection.createStatement().executeQuery("SELECT * FROM people"));
        } catch (SQLException ex) {
            ex.printStackTrace();
            return new Person[0];
        }

    }

    private Person[] processPeople(ResultSet resultSet) throws SQLException {
        List<Person> people = new ArrayList<>();
        while(resultSet.next())
            people.add(processPerson(resultSet));
        return people.toArray(new Person[people.size()]);
    }

    private Person processPerson(ResultSet resultSet) throws SQLException {
        return new Person(resultSet.getString("first_name"), new Mail(resultSet.getString("email")));
    }

}
