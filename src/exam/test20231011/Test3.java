package exam.test20231011;

import java.util.*;

/**
 * @Description:
 * @Author: xuzixin9
 * @Date: 2023/10/11 19:56
 */
//稀疏存储
public class Test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String[]> strArr = new ArrayList<>();
        //读取n行输入
        for (int i = 0; i < n; i++) {
            String str = in.nextLine();
            //按逗号分割字符串
            String[] strArrTemp = str.split(" ");
            strArr.add(strArrTemp);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strArr.get(i).length; j++) {
                System.out.println(strArr.get(i)[j]);
            }
        }
        Map<Long, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Opea opea = Opea.init(strArr.get(i));
            if(opea == null){
                break;
            }
            if(opea.command.equals("Write")){
                for (int j = 0; j < opea.length; j++) {
                    map.put(opea.address + j, opea.data.substring(j * 2, j * 2 + 2));
                }
            } else if(opea.command.equals("Read")){
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < opea.length; j++) {
                    String data = map.get(opea.address + j);
                    if(data == null){
                        sb.append("00");
                    } else {
                        sb.append(data);
                    }
                }
                System.out.println(sb.toString());
            } else if(opea.command.equals("Clear")){
                map.clear();
            }

        }
    }
}

class Opea {
    String command;
    Long address;
    Long length;
    String data;

    public static Opea init(String[] str) {
        Opea opea = new Opea();
        int strLength = str.length;
        if("Write".equals(str[0])){
            if(strLength == 4){
                opea.command = str[0];
                //64位无符号十六进制数转换为十进制数
                opea.address = Long.parseLong(str[1], 16);
                //64位无符号十进制数转换为十进制数
                opea.length = Long.parseLong(str[2]);
                //字节流
//                if(opea.length * 2 < str[3].length()){
//                    return null;
//                }
//                substring(0, opea.length * 2);
                opea.data = str[3];
                return opea;
            }
        } else if("Read".equals(str[0])){
            if(strLength == 3){
                opea.command = str[0];
                //64位无符号十六进制数转换为十进制数
                opea.address = Long.parseLong(str[1].substring(2), 16);
                //64位无符号十进制数转换为十进制数
                opea.length = Long.parseLong(str[2]);
                return opea;
            }
        } else if("Clear".equals(str[0])){
            if(strLength == 1){
                opea.command = str[0];
                return opea;
            }
        } else {
            return null;
        }
        return null;
    }
}
