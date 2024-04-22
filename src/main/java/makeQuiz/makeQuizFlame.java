package makeQuiz;

import java.util.Scanner;

public class makeQuizFlame {
  //作問画面のメインフレーム
  //メインフレームから作問ボタンで遷移

  SendQuizData sender = new SendQuizData();

  public void MakeData(){
    //本来は画面入力だが、とりあえず標準入力で実装
    Scanner sc = new Scanner(System.in);

    System.out.print("画像のパスを入力してください: ");
    String file_path = sc.nextLine();

    System.out.print("ジャンルを入力してください: ");
    String genre = sc.nextLine();

    System.out.print("問題を入力してください: ");
    String question = sc.nextLine();

    System.out.print("答えを入力してください: ");
    String answer = sc.nextLine();

    sender.SendData(file_path, genre, question, answer);
  }

  public void MakeData2(){
    sender.SendData("file/path/example.jpg", "Social", "What is the capital of Japan?", "Tokyo");
  }
}
