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
        // �ǳƸ�ʽ����16���ַ���֧��Ӣ�ġ�����
        String regStr = "^[a-zA-Z0-9]{5,16}$";
        return UserName.matches(regStr);
    }
	public static boolean rexCheckPassword(String pwd) {
		//�����ʽ��6-18λ����
		String regStr = "^[a-zA-Z0-9]{5,18}$";
		return pwd.matches(regStr);
	}

}
