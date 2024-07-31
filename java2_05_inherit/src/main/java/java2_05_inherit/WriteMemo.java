package java2_05_inherit;

public class WriteMemo {
public static void main(String[] args) {
Memo pocketbook = new Pocketbook("TEST");

// write to memo
pocketbook.text = "Axiz at 9 o'clock";

// Output notes to standard output
pocketbook.printMemo();
//delete the note
//pocketbook.deleteMemo();

//Output notes to standard output
pocketbook.printMemo();
	}
}