package jp.co.axiz.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jp.co.axiz.pet.Cat;
import jp.co.axiz.pet.Dog;
import jp.co.axiz.pet.Lizard;
import jp.co.axiz.util.PetUtil;

/**
 * PetUtilクラスのテストケース
 */
public class PetUtilTest {

    @Test
    public void isNullOrEmptyTest1() {
        String str = "a";

        boolean result = PetUtil.isNullOrEmpty(str);
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void isNullOrEmptyTest2() {
        String str = "";

        boolean result = PetUtil.isNullOrEmpty(str);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isNullOrEmptyTest3() {
        String str = null;

        boolean result = PetUtil.isNullOrEmpty(str);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isNumberTest1() {
        String str = "1234";

        boolean result = PetUtil.isNumber(str);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isNumberTest2() {
        String str = "abc";

        boolean result = PetUtil.isNumber(str);
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void checkAndParseIntTest1() {
        String str = "1234";

        Integer result = PetUtil.checkAndParseInt(str);
        Integer expected = 1234;

        assertEquals(expected, result);
    }

    @Test
    public void checkAndParseIntTest2() {
        String str = "abc";

        Integer result = PetUtil.checkAndParseInt(str);
        Integer expected = null;

        assertEquals(expected, result);
    }

    @Test
    public void getOptionTitleStrTest1() {
        Dog dog = new Dog();

        String result = PetUtil.getOptionTitleStr(dog);
        String expected = "散歩場所";

        assertEquals(expected, result);
    }

    @Test
    public void getOptionTitleStrTest2() {
        Cat cat = new Cat();

        String result = PetUtil.getOptionTitleStr(cat);
        String expected = "お気に入り遊具";

        assertEquals(expected, result);
    }

    @Test
    public void getOptionTitleStrTest3() {
        String result = PetUtil.getOptionTitleStr(null);
        String expected = "-";

        assertEquals(expected, result);
    }

    @Test
    public void getOptionStrTest1() {
        Dog dog = new Dog();
        dog.setWalkingPlace("代々木公園");

        String result = PetUtil.getOptionStr(dog);
        String expected = "代々木公園";

        assertEquals(expected, result);
    }

    @Test
    public void getOptionStrTest2() {
        Cat cat = new Cat();
        cat.setFavoriteItem("猫じゃらし");

        String result = PetUtil.getOptionStr(cat);
        String expected = "猫じゃらし";

        assertEquals(expected, result);
    }

    @Test
    public void getOptionStrTest3() {
        String result = PetUtil.getOptionStr(null);
        String expected = "-";

        assertEquals(expected, result);
    }

    @Test
    public void isDogTest1() {
        Dog dog = new Dog();
        boolean result = PetUtil.isDog(dog);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isDogTest2() {
        Cat cat = new Cat();
        boolean result = PetUtil.isDog(cat);
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void isCatTest1() {
        Cat cat = new Cat();
        boolean result = PetUtil.isCat(cat);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isCatTest2() {
        Dog dog = new Dog();
        boolean result = PetUtil.isCat(dog);
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void isAnimalTest1() {
        Cat cat = new Cat();
        boolean result = PetUtil.isAnimal(cat);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isAnimalTest2() {
        Lizard lizard = new Lizard();
        boolean result = PetUtil.isAnimal(lizard);
        boolean expected = false;

        assertEquals(expected, result);
    }

    @Test
    public void isReptileTest1() {
        Lizard lizard = new Lizard();
        boolean result = PetUtil.isReptile(lizard);
        boolean expected = true;

        assertEquals(expected, result);
    }

    @Test
    public void isReptileTest2() {
        Cat cat = new Cat();
        boolean result = PetUtil.isReptile(cat);
        boolean expected = false;

        assertEquals(expected, result);
    }
}