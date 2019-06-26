public class Dog extends Animal {
    //5. Создать классы Собака и Кот с наследованием от класса Животное;
    public double runLimit;

    public double jumpLimit;

    public double swimLimit;

    public Dog (double runLimit, double jumpLimit,double swimLimit){
        this.runLimit = runLimit;
        this.jumpLimit= jumpLimit;
        this.swimLimit=swimLimit;
    }
    public void run (double distanceX){
        if (distanceX>0 && distanceX<runLimit){
            System.out.println("run:true");
        }
    }
    public void jump (double distanceY){
        if (distanceY>0 && distanceY<jumpLimit){
            System.out.println("jump:true");
        }
    }
    public void swim (double distanceZ){
        if (distanceZ>0 || distanceZ<swimLimit){
            System.out.println("swim:true");
        }
    }
}
