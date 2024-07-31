package java2_05_inherit;

public class Memo extends Object{
public String text; // field

public Memo() {
	System.out.println("Memoclass argumentless constructor");
}
public Memo(String inputStr) {
	System.out.println("Memoclass constructor with arguments");
	System.out.println("The input value is" + inputStr + " . ");
}
//Output notes to standard output
public final void printMemo() {
System.out.println(text);
}
}