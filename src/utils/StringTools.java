package utils;

public class StringTools {
	public static boolean isEmpty(String str) {
		if(str.trim() == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean rexCheckUserName(String UserName) {
        // 昵称格式：限16个字符，支持英文、数字
        String regStr = "^[a-zA-Z0-9]{5,16}$";
        return UserName.matches(regStr);
    }
	public static boolean rexCheckPassword(String pwd) {
		//密码格式：6-18位数字
		String regStr = "^[a-zA-Z0-9]{5,18}$";
		return pwd.matches(regStr);
	}

}
