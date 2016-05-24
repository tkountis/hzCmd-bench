package hz.map.member;

import hz.model.Person;

import static utils.Utils.randDouble;

public class LoadPersons extends Loader {

    public int orgs=10;
    public double minSalary=1.0;
    public double maxSalary=1000.0;

    public Object getValue(int key) {

        int org = random.nextInt(orgs);
        double salary = randDouble(random, minSalary, maxSalary);

        return new Person(key, org, "firstName"+key, "lastName"+key, salary);
    }

}