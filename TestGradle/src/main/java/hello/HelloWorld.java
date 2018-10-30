package hello;

import org.joda.time.LocalTime;

public class HelloWorld {
	public static void main(String[] args) {
		 System.out.println("The current local time is " + (new LocalTime()));

		 Greeter gr = new Greeter();
		 System.out.println(gr.sayHello());
		 System.out.println((new Greeter()).sayHello());
	}
}