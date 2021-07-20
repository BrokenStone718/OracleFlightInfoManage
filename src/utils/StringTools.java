package utils;

public class StringTools {
	public static boolean isEmpty(String str) {
		if(str.trim() == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	//限制用户名格式
	public static boolean rexCheckUserName(String UserName) {
        // 昵称格式：限5-16个字符，支持英文、数字
        String regStr = "^[a-zA-Z0-9]{5,16}$";
        return UserName.matches(regStr);
    }
	//限制密码格式
	public static boolean rexCheckPassword(String pwd) {
		//密码格式：5-18位数字英文
		String regStr = "^[a-zA-Z0-9]{5,18}$";
		return pwd.matches(regStr);
	}
	//限制航班号格式
	public static boolean rexCheckHBH(String hbh) {
		String regStr = "^[A-Z]{2}[0-9]{4}$";
		return hbh.matches(regStr);
	}
	//限制航站楼格式
	public static boolean rexCheckHZL(String hzl) {
		String regStr = "^\\d{1}[\\u53f7][\\u822a][\\u7ad9][\\u697c]$";
		return hzl.matches(regStr);
	}

	//限制候机厅格式
	public static boolean rexCheckHJT(String hjt) {
		String regStr = "^[\\u4e1c\\u897f][\\u5019][\\u673a][\\u5385]$";
		return hjt.matches(regStr);
	}
	//限制机长姓名为2-4个汉字
	public static boolean rexCheckJZXM(String jzxm) {
		String regStr = "^[\\u4E00-\\u9FA5]{2,4}$";
		return jzxm.matches(regStr);
	}
	//限制是否延误，要么0要么1
	public static boolean rexCheckSFYW(String sfyw) {
		String regStr = "^[01]{1}$";
		return sfyw.matches(regStr);
	}
	//限制城市格式为2-10个汉字
	public static boolean rexCheckCity(String city) {
		String regStr = "^[\\u4E00-\\u9FA5]{2,10}$";
		return city.matches(regStr);
	}
	//限制日期格式为年-月-日
	public static boolean rexCheckDate(String date) {
		String regStr = "^\\d{4}(-)\\d{1,2}\\1\\d{1,2}$";
		return date.matches(regStr);
	}
}
