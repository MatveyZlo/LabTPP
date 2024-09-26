package org.example;

public abstract class insect extends Animal {
    public final int age;

    public static int count = 0;

   public insect(String name, int age, int maxSwimDist, int maxRunDist)
    {
        super(name, maxRunDist, maxSwimDist);
        this.age = age;
        count++;
    }
    public void lifespan(){
        System.out.println("Средняя продолжительность жизни: " + this.name + " ("  + this.getClass().getSimpleName()+"): " + this.age);
   }
}
