import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test {

    public static void main(String args[]) {
        List<Person> people = new ArrayList<>();
        Person person1 = new Person();
        person1.setName("Celebrity");
        Person person2 = new Person();
        person2.setName("Person2");
        person2.getKnowPeople().add(person1);
        Person person3 = new Person();
        person3.setName("Person3");
        person3.getKnowPeople().add(person1);

        people.add(person1);
        people.add(person2);
        people.add(person3);
        System.out.print(findCelebrity(people));
    }
    static Person findCelebrity(List<Person> people){
        Person celebrity = null;
        int match = 0;
        for(Person person: people){
            if(person.getKnowPeople().isEmpty())
                celebrity = person;
        }

        if(celebrity != null) {
            for (Person person : people) {
                if (person.getKnowPeople().contains(celebrity))
                    match++;
            }
            if (people.size()-1 == match) {
                return celebrity;
            }
        }
        return null;
    }

    static class Person{
        String name;
        List<Person> knowPeople;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<Person> getKnowPeople() {
            if(knowPeople == null){
                knowPeople = new ArrayList<>();
            }
            return knowPeople;
        }

        public void setKnowPeople(List<Person> knowPeople) {
            this.knowPeople = knowPeople;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name);
        }

        @Override public int hashCode() {
            return Objects.hash(name);
        }

        @Override public String toString() {
            final StringBuilder sb = new StringBuilder("Person{");
            sb.append("name='").append(name).append('\'');
            sb.append('}');
            return sb.toString();
        }
    }
}

