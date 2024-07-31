package java2_06_abstract;

public class SmartPhone implements Lockable{
	public boolean isLock = false;
	public boolean isLock() {
		return isLock;
	}
	public void lock() {
		isLock = true;
	}
	public void unlock(int pass) {
		if (pass == Lockable.PASSWORD2) {
			isLock = false;
		}
	}
}
