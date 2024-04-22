package makeQuiz;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class LoadImage {

  private String file_path;
  // 選択されたファイルをアップロードするメソッド
  private void uploadFile(File file) {
    // アップロード先のURL
    String uploadUrl = "http://localhost/minhaya/upload.php";

    try {
        URL url = new URL(uploadUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        // リクエストメソッドを設定
        connection.setRequestMethod("POST");
        // リクエストのボディを有効にする
        connection.setDoOutput(true);
        // マルチパート形式でリクエストを送信
        try (OutputStream outputStream = connection.getOutputStream();
             FileInputStream fileInputStream = new FileInputStream(file)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
        }
        // レスポンスを取得
        getFilePath(connection);
        // 接続を閉じる
        connection.disconnect();
    } catch (IOException e) {
        e.printStackTrace();
    }
  }

  private void getFilePath(HttpURLConnection connection){
    try {
      int responseCode = connection.getResponseCode();
      if (responseCode == HttpURLConnection.HTTP_OK){ 
        // レスポンスデータを読み取り
        InputStream inputStream = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        // JSON形式のレスポンスを解析
        JSONObject jsonResponse = new JSONObject(response.toString());
        //画像ファイルのパスを取得(データベースへ挿入用)
        this.file_path = jsonResponse.getString("filePath");

        // アップロードされたファイルのパスを表示
        System.out.println("Uploaded file path: " + this.file_path);
      } else {
          // アップロード失敗時の処理
          System.out.println("Failed to upload file. Response code: " + responseCode);
      }
    } catch (IOException e){
        e.printStackTrace();
    } catch (JSONException e){
        e.printStackTrace();
    }
  }
}
