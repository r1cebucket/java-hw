public class Dog {
        private int age;
        private String owner;
        private String breed;

        public Dog() {
        }

        public int getAge() {
                return age;
        }

        public void setAge(int age) {
                this.age = age;
        }

        public String getOwner() {
                return owner;
        }

        public void setOwner(String owner) {
                this.owner = owner;
        }

        public String getBreed() {

                return breed;
        }

        public void setBreed(String breed) {
                this.breed = breed;
        }

        public Dog(int age, String owner, String breed) {
                this.age = age;
                this.owner = owner;
                this.breed = breed;
        }

        public static boolean hasSameOwner(Dog dog1, Dog dog2) {
                return dog1.getOwner().equals(dog2.getOwner());
        }

        public static double avgAge(Dog[] dogs) {
                double totalAge = 0;
                for (Dog dog : dogs) {
                        totalAge += dog.getAge();
                }
                return totalAge / dogs.length;
        }

        public String toString() {
                return String.format("%s: Owner: %s, Age:%d", breed, owner, age);
        }

        public static void main(String[] args) {
                Dog[] dogs = new Dog[5];
                dogs[0] = new Dog(4, "owner 0", "breed 0");
                dogs[1] = new Dog(2, "owner 1", "breed 1");
                dogs[2] = new Dog(3, "owner 2", "breed 2");
                dogs[3] = new Dog(1, "owner 3", "breed 3");
                dogs[4] = new Dog(5, "owner 4", "breed 4");

                System.out.println(hasSameOwner(dogs[0], dogs[1]));
                System.out.println(avgAge(dogs));
                System.out.println(dogs[0].toString());
        }
}