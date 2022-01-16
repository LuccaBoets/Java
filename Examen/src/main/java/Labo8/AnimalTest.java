package Labo8;

import org.junit.Assert;
import org.junit.Test;

public class AnimalTest {

    @Test
    public void addAnimalOne(){
        var animal1 = new Animal("blacky", AnimalType.DOG,"ik");

        AnimalClinic animalClinic = new AnimalClinic();
        animalClinic.addAnimal(animal1);

        Assert.assertTrue(animalClinic.getAnimals().contains(animal1));
        Assert.assertEquals(1 ,animalClinic.countAnimals());
    }

    @Test
    public void addAnimalTwoDiffrent(){
        var animal1 = new Animal("blacky", AnimalType.DOG,"ik");
        var animal2 = new Animal("garfield", AnimalType.CAT,"ik");

        AnimalClinic animalClinic = new AnimalClinic();
        animalClinic.addAnimal(animal1);
        animalClinic.addAnimal(animal2);

        Assert.assertTrue(animalClinic.getAnimals().contains(animal1));
        Assert.assertTrue(animalClinic.getAnimals().contains(animal2));
        Assert.assertEquals(2 ,animalClinic.countAnimals());
    }

    @Test
    public void addAnimalTwoSame(){
        var animal1 = new Animal("garfield", AnimalType.CAT,"ik");

        AnimalClinic animalClinic = new AnimalClinic();
        animalClinic.addAnimal(animal1);
        animalClinic.addAnimal(animal1);

        Assert.assertTrue(animalClinic.getAnimals().contains(animal1));
        Assert.assertEquals(1 ,animalClinic.countAnimals());
    }

    @Test
    public void findAnimal(){
        var animal1 = new Animal("garfield", AnimalType.CAT,"ik");

        AnimalClinic animalClinic = new AnimalClinic();
        animalClinic.addAnimal(animal1);

        Assert.assertEquals(animal1 ,animalClinic.findAnimal(animal1.getName(),animal1.getType()));
        Assert.assertEquals(1 ,animalClinic.countAnimals());
    }

    @Test
    public void findAnimal2Animals(){
        var animal1 = new Animal("garfield", AnimalType.CAT,"ik");
        var animal2 = new Animal("blacky", AnimalType.DOG,"ik");

        AnimalClinic animalClinic = new AnimalClinic();
        animalClinic.addAnimal(animal1);
        animalClinic.addAnimal(animal2);

        Assert.assertEquals(animal1 ,animalClinic.findAnimal(animal1.getName(),animal1.getType()));
        Assert.assertEquals(2 ,animalClinic.countAnimals());
    }

    @Test
    public void findAnimalNull(){
        var animal1 = new Animal("garfield", AnimalType.CAT,"ik");
        var animal2 = new Animal("blacky", AnimalType.DOG,"ik");

        AnimalClinic animalClinic = new AnimalClinic();
        animalClinic.addAnimal(animal1);

        Assert.assertNull(null ,animalClinic.findAnimal(animal2.getName(),animal2.getType()));
        Assert.assertEquals(1 ,animalClinic.countAnimals());
    }


}
