package kata4.view.process;

import kata4.model.Person;

@FunctionalInterface
public interface Loader {
    Person[] load();
}
