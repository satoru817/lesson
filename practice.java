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
        
        // 人数分布
        int[] dist = { 0, 0, 0, 0, 0, 0 };
        
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
                        dist[5]++;
                    } else if (score >= 70) {
                        evaluation = 4;
                        dist[4]++;
                    } else if (score >= 50) {
                        evaluation = 3;
                        dist[3]++;
                    } else if (score >= 30) {
                        evaluation = 2;
                        dist[2]++;
                    } else if (score >= 0) {
                        evaluation = 1;
                        dist[1]++;
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
            
            int sup = dist[1] + dist[2];
            System.out.println ("評価5: " + dist[5] + "人");
            System.out.println ("評価4: " + dist[4] + "人");
            System.out.println ("評価3: " + dist[3] + "人");
            System.out.println ("評価2: " + dist[2] + "人");
            System.out.println ("評価1: " + dist[1] + "人");
            System.out.println ("夏休みの補習の対象は" + sup + "人です");
            
        }
        
    }
    
}

