import data.*;

import java.util.ArrayList;
import java.util.List;

public class MainJavaPlayground {

    public static void main(String[] args) {

        Animal animal1 = new Dog(0,"Swift", FurColor.BLACK);
        Dog dog1 = new Dog(1, "Stu", FurColor.PATCHED);
        Animal animal2 = new Cat(3, "Tuno", EyesColor.GREEN);
        Cat cat1 = new Cat(2, "Tula", EyesColor.YELLOWISH);

        // inheritance and polymorphism allow us to do the following sort of re-assignation
        animal2 = dog1;
        // obviously, the reverse does not apply
//        cat1 = animal2;

        List<Animal> animalList = new ArrayList<>();  // standard 'List'
        List<? extends Animal> animalUpperBoundList;   // generic covariant 'List' on 'Animal'
        List<? super Dog> dogLowerBoundList;   // generic contravariant 'List' on 'Dog'

        animalList.add(dog1);
        animalList.add(cat1);
        // a standard 'List' does not know what type is obtained when fetching data
//        Dog anyDog = animalList.get(0);
//        Cat anyCat = animalList.get(1);
        Animal anyAnimal = animalList.get(0);
        FurColor furColor = ((Dog) anyAnimal).getFurColor();   // explicit casting, danger!
        // however, assignations are forbidden to avoid conflicts on the enclosing type
//        animalList = (List<Dog>) new ArrayList<Dog>();

        animalUpperBoundList = new ArrayList<>();
        // a generic covariant 'List' can take any type in runtime, so writing into it is not allowed
//        animalUpperBoundList.add(dog1);
//        animalUpperBoundList.add(cat1);
//        animalUpperBoundList.add(animal1);
        // unlike writing, reading is perfectly allowed, but items are always considered the upper-bound type
        Animal anyOtherAnimal = animalUpperBoundList.get(0);
        // assignations are now possible as long as the type rule (? extends Animal) is fulfilled
        animalUpperBoundList = (List<Dog>) new ArrayList<Dog>();

        dogLowerBoundList = new ArrayList<>();
        // a generic contravariant 'List' can take any type in runtime as well
        // writing is allowed this time, but only the lower-bound type
        dogLowerBoundList.add(dog1);
//        dogLowerBoundList.add(cat1);
//        dogLowerBoundList.add(animal1);
        // reading is directly not allowed, because again the type is erased in runtime, so we don't know it in advance
//        Dog anyOtherMoreDog = dogLowerBoundList.get(0);
//        Animal anyOtherMoreDog = dogLowerBoundList.get(0);
        // assignations are possible as well, as long as the type rule (? super Dog) is fulfilled
        dogLowerBoundList = (List<Animal>) new ArrayList<Animal>();
        dogLowerBoundList = (List<Dog>) new ArrayList<Dog>();

        System.out.println("Done!");
    }

}