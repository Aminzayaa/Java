package jp.co.axiz.util;

/**
 * Utilityメソッドをまとめたクラス
 */
public class Utility {

	 /**
     * 引数に指定した文字列が正しいパスワード（axizuser）に
     * 一致するかを判定
     * @param str
     * @return
     */
    public static boolean authentication(String password) {

	    if (password.equals("axizuser")) {

	    	// パスワードが正しい場合
			return true;

	    } else {

	    	// パスワードが正しくない場合
	    	return false;

	    }
    }


}
