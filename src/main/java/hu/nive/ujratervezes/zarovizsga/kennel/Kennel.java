package hu.nive.ujratervezes.zarovizsga.kennel;

import java.util.ArrayList;
import java.util.List;

public class Kennel {
    List<Dog> dogs = new ArrayList<>();

    public List<Dog> getDogs() {
        return new ArrayList<>(dogs);
    }

    public void addDog(Dog dog) {
        dogs.add(dog);
    }

    public void feedAll() {

        for (Dog item : dogs
        ) {
            item.feed();
        }
    }

    public Dog findByName(String name) {
        for (Dog item : dogs) {
            if (item.getName().equals(name)) {

                return item;
            }
        }
        throw new IllegalArgumentException("WWe do not have the dog which name: " + name);
    }

    public void playWith(String name, int hours) {

        findByName(name).play(hours);

    }


    public List<String> getHappyDogNames(int minHappiness) {
        List<String> happyDogs = new ArrayList<>();

        for (Dog item : dogs
        ) {
            if (item.getHappiness() > minHappiness) {
                happyDogs.add(item.getName());
            }
        }
        weDoNotHaveHappyDog(happyDogs);

        return happyDogs;
    }


    private void weDoNotHaveHappyDog(List<String> happyDogs) {
        if (happyDogs.isEmpty()) {
            throw new IllegalArgumentException("We do not have Happy dogs!");
        }
    }

}
