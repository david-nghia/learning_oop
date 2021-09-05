package objectio;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriterReader {

    public static void main(String[] args) {

        Object persons = new ArrayList<>();
        Person p1 = new Person("John", 30, "Male");
        Person p2 = new Person("Rachel", 25, "Female");
        try {
            FileOutputStream f = new FileOutputStream(new File("myObjects.txt"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            ((ArrayList<?>) persons).add( p1);
            persons.add(p2);
            // Write objects to file
            o.writeObject(persons);

            o.close();
            f.close();

            FileInputStream fi = new FileInputStream(new File("myObjects.txt"));
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects

            ArrayList<Person> p = (ArrayList<Person>) oi.readObject();
            System.out.println(p);

            oi.close();
            fi.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}