package java2_06_abstract;

public interface Lockable {
	// field
	int PASSWORD1 = 1024;
	int PASSWORD2 = 2048;

	// method
	boolean isLock();
	void lock();
	void unlock(int pass);
	}