package lesson;

import java.util.HashMap;
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
        
        // 人数分布をHashMapで表現
        HashMap<Integer, Integer> distMap = new HashMap<Integer, Integer> ();
        
        // distMapの初期化（すべての度数を0とする）
        for (int i = 1; i <= 5; i++) {
            distMap.put (i, 0);
        }
        
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
                        distMap.put (5, distMap.get (5) + 1);
                    } else if (score >= 70) {
                        evaluation = 4;
                        distMap.put (4, distMap.get (4) + 1);
                    } else if (score >= 50) {
                        evaluation = 3;
                        distMap.put (3, distMap.get (3) + 1);
                    } else if (score >= 30) {
                        evaluation = 2;
                        distMap.put (2, distMap.get (2) + 1);
                    } else if (score >= 0) {
                        evaluation = 1;
                        distMap.put (1, distMap.get (1) + 1);
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
            
            int sup = distMap.get (1) + distMap.get (2);
            // ラムダ式を使わない場合
            // for (int j = 1; j <= 5; j++) {
            // System.out.println ("評価" + j + ": " + distMap.get (j) + "人");
            // }
            
            // ラムダ式を使った場合
            distMap.forEach ( (key, value) -> System.out.println ("評価" + key + ": " + value + "人"));
            
            System.out.println ("夏休みの補習の対象は" + sup + "人です");
            
        }
        
    }
    
}
