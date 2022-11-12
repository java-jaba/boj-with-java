package zincah;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1259 {

    // 문자열 거꾸로 뒤집는 method

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> resultList = new ArrayList<>();

        /**
         *  for문으로 reverse 했을 경우
         *  124ms
         */
        /*
        while(true){
            String str = br.readLine();

            if(str.equals("0")){
                break;
            }

            int divLen = str.length()/2;

            String first = str.substring(0, divLen+1);
            String last = "";

            if(str.length()%2 != 0){
                last = str.substring(divLen);
            }else{
                last = str.substring(divLen-1);
            }

            String reverseLast = "";
            for(int i=last.length()-1; i>=0; i--){
                reverseLast += String.valueOf(last.charAt(i));
            }

            String result = "no";
            if(first.equals(reverseLast)){
                result = "yes";
            }

            resultList.add(result);
        }*/

        /**
         *  StringBuffer.reverse() method 사용
         *  120ms
         */
        while(true){

            // 1. 문자열 입력
            String str = br.readLine();

            // 2. 문자열이 0과 일치할때 반복을 종료한다.
            if(str.equals("0")){
                break;
            }

            // 3. 입력된 문자를 거꾸로 읽는다.
            StringBuffer sb = new StringBuffer(str);
            String reverseStr = sb.reverse().toString();

            // 4. 본래 입력값과 비교한다.
            if(str.equals(reverseStr)){
                resultList.add("yes");
            }else{
                resultList.add("no");
            }
        }

        // list 저장된 결과를 출력한다.
        for(String result : resultList){
            System.out.println(result);
        }


    }
}
