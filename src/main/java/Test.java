import com.sun.org.apache.xerces.internal.util.EncodingMap;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
        Test o = new Test();
        System.out.println(o.checkCommonStr("1AB2345CD","EF"));

    }

    /**
     * str1短字符串  str2长字符串
     * @param str1
     * @param str2
     * @return
     */
    private String checkCommonStr(String str1, String str2) {
        if (str1.length() > str2.length()) {
            String temp = str1;
            str1 = str2;
            str2 = temp;
        }
        String commonStr = "";
        for (int i = 0; i < str1.length(); i++) {
            int j = str2.indexOf(str1.substring(i, i + 1));//str2 位置
            if (j > -1) {
                int k = i;
                for (;k < str1.length() - i; k++) {
                    if (j + k > str2.length()) {
                        break;
                    }
                    if (str2.charAt(j+k-i) == str1.charAt(k)) {
                        continue;
                    } else {
                        break;
                    }
                }
                commonStr = str1.substring(i,k).length() > commonStr.length() ? str1.substring(i,k) : commonStr;
            } else {
                i++;
            }
        }
        return "".equals(commonStr) ? "-1" : commonStr;
    }
}
