package jp.co.axiz.pet;

/**
 * Interface with common methods for Pet
 */
public interface Pet {

	/**
	 * Get name
	 */
	String getName();

	/**
	 * Set name
	 */
	void setName(String _name);

	/**
	 * Set age
	 */
	int getAge();

	/**
	 * Set age
	 */
	void setAge(int _age);

	/**
	 * Get body length
	 */
	int getHeight();

	/**
	 * Set body length
	 */
	void setHeight(int _height);

	/**
	 * Get weight
	 */
	int getWeight();

	/**
	 * Set weight
	 */
	void setWeight(int _weight);
}