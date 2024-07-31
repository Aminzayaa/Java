package java2_05_inherit;

public class Pocketbook extends Memo {
public Pocketbook() {
System.out.println("Pocketbook class argumentless constructor");
}
public Pocketbook(String inputStr) {
	super(inputStr);
	System.out.println("Pocketbook class constructor with arguments");
	System.out.println("The input value is" + inputStr + ".");
}
//	//Output notes to standard output
//	public void printMemo() {
//	System.out.println("Overridden.");
//	}
	//cancel the note
	public void deleteMemo() {
	this.text = "blank";
	System.out.println("I deleted the memo.");
	}
}