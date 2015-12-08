package kata4.model;

public class Person {

    private final String name;
    private final Mail mail;

    public Person(String name, Mail mail) {
        this.name = name;
        this.mail = mail;
    }

    public Mail getMail() {
        return mail;
    }

}
