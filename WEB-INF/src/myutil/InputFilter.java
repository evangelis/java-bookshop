//InputFilter.java
package myutil;

public final class InputFilter{
	public static boolean isValidPhone(String num){
		if (num.length() != 8) return false;
		for (int i=0;i<num.length();i++){
			char c= num.charAt(i);
			if (c <'0' || ,>'9')
				return false;
		}
		return true;
	}
	public static int parsePositiveInt(String str){
		if(str == null || str.trim().length() == 0)
			return 0;
		int result =0;
		try{
			result = Integer.parseInt(str);

		}
		catch(NumberFormatException ex){
			return 0;
		}
		return (result >0)? result : 0;

	}

	public static String htmlFilter(String msg){
		if (msg == null) return null;
		int len = msg.length();
		StringBuilder result = new StringBuilder(len +20);
		for (int i=0;i<len;i++){
			char aChar = msg.charAt(i);
			switch (aChar){
				case '<':
					result.append("&lt;");
					break;
				case '>':
					result.append("&gt;");
					break;
				case '"':
					result.append("&quot;");
					break;
				case '&':
					result.append("&amp;");
					break;
				default:
					result.append(aChar);

			}

		}
		return result.toString();
	}
}