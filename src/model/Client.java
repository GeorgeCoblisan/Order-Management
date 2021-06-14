package model;

/**
 * @Author: Coblisan George
 *
 * @Since: 19.04.2021
 * @Source Client
 */

public class Client {
    private int id;
    private String name;
    private String email;
    private int age;

    public Client(int id, String name, String email, int age) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Client(String name, String email, int age) {
        super();
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public Client(int ID) {
        this.id = ID;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
