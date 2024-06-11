/*
* 1- Create a Person class
* 2- with attributes name, age, and address.
* 3- Include constructors,
* 4- getters,
* 5- setters.
* 6- Modify the Person class to validate that age is between 0 and 150.
*  Throw an IllegalArgumentException if the value is out of range.
* 7- Modify Person and Student to extend PersonRecord and
* implement getDetails to return a string with the person's details.
*/


//1
public class Person extends PersonRecord {
//2
    private String name;
    private int age;
    private String address;

   // 3 the constructor befor modifay.
//    public Person(String name, int age, String address) {
//        this.name = name;
//        this.age = age;
//        this.address = address;
//    }

    // Constructor after modifiy.
    public Person(String name, int age, String address) {
        setName(name);
        setAge(age);
        setAddress(address);
    }

    // 4 the getter for all 3 attributes
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    // 5 the Setters for all 3  attributes
    public void setName(String name) {
        this.name = name;
    }


//     age seteer befor modify.
//       public void setAge(int age) {
//            this.age = age;
//       }

//6
public void setAge(int age) {
    if (age < 0 || age > 150) {
        throw new IllegalArgumentException("Age must be between 0 and 150");
    }
    this.age = age;
}



    public void setAddress(String address) {
        this.address = address;
    }

   // 7
    public String getDetails(){
        return toString();
    }

    @Override
    public String toString() {
        return super.toString() + "Name: " + name + ", Age: " + age + ", Address: " + address;
    }





}
