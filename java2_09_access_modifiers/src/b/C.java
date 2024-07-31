package b;

import a.A;

public class C  extends A{
	public void func() {
		A a = new A();
		a.name = "TEST";
//		a.address = "TEST";
//		a.tel = "090-0000-0000";
//		a.age = 22;
		
		super.name = "TEST";
		super.address = "TEST";
//		super.tel = "090-0000-0000";
//		super.age = 22;
		
		B b = new B();
		b.name = "TEST";
		b.address = "TEST";
		b.tel = "090-0000-0000";
		b.age = 22;
		}

}
