package study;

import java.util.Random;
import java.util.Scanner;

public class UpDownGame {
    public static void main(String[] args) {
        String inputResult = "";
        Scanner scanner = new Scanner(System.in);

        int minNum = 1; //최소값
        int maxNum = 100; //최대값
        int loopCount = 0; //시도횟수

        Random random = new Random();
        System.out.println("랜덤값은 : " + (random.nextInt(100) + 1));

        while (true) {
            loopCount++; //시도횟수 증가
//            System.out.println("minNum : " + minNum + " / maxNum : " + maxNum);
            //최소값과 최대값이 같을 경우
            if (minNum == maxNum) {
                System.out.println("더 이상 진행할 수 없습니다. 게임을 종료합니다.");
                break;
            }

            //컴퓨터가 선택한 값
            int selectNum = random.nextInt(maxNum - minNum) + minNum;
            System.out.println("당신이 고른 숫자가 [" + selectNum + "]가 맞습니까?");

            inputResult = scanner.next(); //유저판별

            if (inputResult.equals("U")) { //컴퓨터 선택값보다 큰 경우
                minNum = selectNum + 1;
            } else if (inputResult.equals("D")) { //컴퓨터 선택값보다 작은 경우
                maxNum = selectNum - 1;
            } else if (inputResult.equals("S")) { // 정답
                System.out.println("정답입니다. 시도횟수[" + loopCount + "]회");
                break;
            } else { // U,D,S 외 값을 입력한 경우
                System.out.println("잘못입력하셨습니다. (U/D/S 만 입력가능)");
                inputResult = scanner.next();
            }
        }
    }
}

//사용자 임의값 입력
//run
//랜덤함수 출력
//위,아래,정답 입력 (U,D,S)
//종료