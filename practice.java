package lesson;

import java.util.Scanner;

public class practice {
    
    // テストの点数の入力を受け取る関数。範囲外の場合例外を発生させる
    public static int getScore (Scanner scanner) {
        int score = scanner.nextInt ();
        if (score > 100 || score < 0) {
            throw new IllegalArgumentException ();
        } else {
            return score;
        }
    }
    
    public static void main (String[] args) {
        // TODO Auto-generated method stub
        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int E = 0;
        
        try (Scanner scanner = new Scanner (System.in)) {
            while (true) {
                System.out.println ("学生の名前を入力してください");
                String name = scanner.nextLine ();
                System.out.println (name + "さんのテストの点数を入力してください");
                
                // try catch文で入力値が例外の場合を処理する。
                try {
                    int score = getScore (scanner);
                    
                    int evaluation = 0;
                    if (score >= 90) {
                        evaluation = 5;
                        A++;
                    } else if (score >= 70) {
                        evaluation = 4;
                        B++;
                    } else if (score >= 50) {
                        evaluation = 3;
                        C++;
                    } else if (score >= 30) {
                        evaluation = 2;
                        D++;
                    } else if (score >= 0) {
                        evaluation = 1;
                        E++;
                    }
                    scanner.nextLine ();// enter
                    System.out.println (name + "さんの評価は" + evaluation);
                    System.out.println ("入力を続けますか?");
                    String continueString = scanner.nextLine ();
                    if (!continueString.equals ("yes")) {
                        break;
                    } else {
                        continue;
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println ("0から100の間の整数値を入力してください");
                    // enterの影響をなくす
                    scanner.nextLine ();
                }
                
            }
            
            int sup = D + E;
            System.out.println ("評価5: " + A + "人");
            System.out.println ("評価4: " + B + "人");
            System.out.println ("評価3: " + C + "人");
            System.out.println ("評価2: " + D + "人");
            System.out.println ("評価1: " + E + "人");
            System.out.println ("夏休みの補習の対象は" + sup + "人です");
            
        }
        
    }
    
}
