package utils;

public class StringTools {
	public static boolean isEmpty(String str) {
		if(str.trim() == null || "".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}
	//�����û�����ʽ
	public static boolean rexCheckUserName(String UserName) {
        // �ǳƸ�ʽ����5-16���ַ���֧��Ӣ�ġ�����
        String regStr = "^[a-zA-Z0-9]{5,16}$";
        return UserName.matches(regStr);
    }
	//���������ʽ
	public static boolean rexCheckPassword(String pwd) {
		//�����ʽ��5-18λ����Ӣ��
		String regStr = "^[a-zA-Z0-9]{5,18}$";
		return pwd.matches(regStr);
	}
	//���ƺ���Ÿ�ʽ
	public static boolean rexCheckHBH(String hbh) {
		String regStr = "^[A-Z]{2}[0-9]{4}$";
		return hbh.matches(regStr);
	}
	//���ƺ�վ¥��ʽ
	public static boolean rexCheckHZL(String hzl) {
		String regStr = "^\\d{1}[\\u53f7][\\u822a][\\u7ad9][\\u697c]$";
		return hzl.matches(regStr);
	}

	//���ƺ������ʽ
	public static boolean rexCheckHJT(String hjt) {
		String regStr = "^[\\u4e1c\\u897f][\\u5019][\\u673a][\\u5385]$";
		return hjt.matches(regStr);
	}
	//���ƻ�������Ϊ2-4������
	public static boolean rexCheckJZXM(String jzxm) {
		String regStr = "^[\\u4E00-\\u9FA5]{2,4}$";
		return jzxm.matches(regStr);
	}
	//�����Ƿ�����Ҫô0Ҫô1
	public static boolean rexCheckSFYW(String sfyw) {
		String regStr = "^[01]{1}$";
		return sfyw.matches(regStr);
	}
	//���Ƴ��и�ʽΪ2-10������
	public static boolean rexCheckCity(String city) {
		String regStr = "^[\\u4E00-\\u9FA5]{2,10}$";
		return city.matches(regStr);
	}
	//�������ڸ�ʽΪ��-��-��
	public static boolean rexCheckDate(String date) {
		String regStr = "^\\d{4}(-)\\d{1,2}\\1\\d{1,2}$";
		return date.matches(regStr);
	}
}
