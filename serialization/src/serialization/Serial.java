package serialization;
import java.io.*;
public class Serial
{
	public static void main(String args[])
	{
	//object serialisation
	try
	{
	Myclass ob1 = new Myclass("Hello",7,2.7);
	System.out.println("Object1" +ob1);

	FileOutputStream fos = new FileOutputStream("serial.txt");
	ObjectOutputStream oos = new ObjectOutputStream(fos);
	oos.writeObject(ob1);
	oos.flush();
	oos.close();
	}
	catch(Exception e)
	{
	System.out.println(e);
	System.exit(0);
	}
	try
	{
	Myclass ob2;
	FileInputStream fis = new FileInputStream("serial.txt");
	ObjectInputStream ois = new ObjectInputStream(fis);

	ob2 = (Myclass) ois.readObject();
	ois.close();
	System.out.println("Object2:" + ob2);
	}
	catch(Exception e)
	{
	System.out.println(e);
	System.exit(0);
	}
	}
}

class Myclass implements Serializable
{
	String s;
	int i;
	double d;
	public Myclass(String s, int i,double d)
	{
	this.s=s;
	this.i=i;
	this.d=d;
	}
	public String toString()
	{
	return "s= "+"\"" + s + "\"" + "|" +"i="+ i +"|" +"d=" + d;
	}

}
	
					