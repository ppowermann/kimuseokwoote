package calculator;

import javax.swing.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String separator = ",|:|";//기본 구분자 모음

        System.out.print("입력할 문자열:");
        String str = sc.nextLine();
        int sum = 0;


        // "//\n은 입력값의 반드시 0번째1번째3번째4번째 에 올테니까
        // 이 조건이 항상나오므로 커스텀 문자는 항상 2번째에 나옴
        if (str.charAt(0) == '/' &&
                str.charAt(1) == '/' &&
                str.charAt(3) == '\\' &&
                str.charAt(4) == 'n') {
            separator += str.charAt(2); //그래서 str 2번째 char를 추출해서 구분자에 추가함
            str = str.substring(5);
            // 서브스트링이 없으면 //\n도 배열로 추가되니
            // 계산할 숫자가 시작되는 str의 5번째부터 배열에 추가함


            //커스텀 구분자가 없다면 문자열은 반드시 시작이
            //숫자이므로 두번째 조건문에서 str의 0번째가 숫자인지 확인함
            //숫자가 맞으면 커스텀구분자가 없으므로 계산시작
        } else if ((Character.isDigit(str.charAt(0)))) {
            System.out.println("커스텀할 구분자가 없습니다");
        } else {
            throw new IllegalArgumentException("잘못된 값을 입력하였습니다");

            //if조건 elseif조건 이외에 나머지 경우는
            //문자열 덧셈계산기에서 오류이므로
            //오류발생시킨다
        }

        String[] results = str.split("[" + separator + "]");
        //separator의 안의 기본구분자 또는 커스텀 구분자가 추가됫다면
        //구분자를 기준으로 문자열안에 숫자들을 구벌해서
        //results배열안에 넣는다


        for (String result : results) {
            //로직으로 완료된 String results를 하나씩 꺼내서
            //str>>>int로 바꿔서 num변수안에 넣고
            //반복하여 최종값 sum에 축척한다
            int num = Integer.parseInt(result);
            sum += num;

        }
        System.out.println(sum);
        //완료

    }
}