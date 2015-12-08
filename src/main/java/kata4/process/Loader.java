package kata4.process;

import kata4.model.Person;

@FunctionalInterface
public interface Loader {
    Person[] load();
}
