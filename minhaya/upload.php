<?php
// データベース設定ファイルを含む
include 'api.php';

// ファイルがアップロードされた場合の処理
if ($_FILES["file"]["error"] == UPLOAD_ERR_OK) {
    // 一時ファイルパスからファイル名を取得
    $fileName = basename($_FILES["file"]["name"]);
    
    // 画像が保存されるディレクトリパス
    $uploadDir = "upload/";

    // アップロードディレクトリが存在しない場合は作成
    if (!file_exists($uploadDir)) {
        mkdir($uploadDir, 0777, true);
    }

    // 画像ファイルをアップロードディレクトリに移動
    $filePath = $uploadDir . $fileName;
    if (move_uploaded_file($_FILES["file"]["tmp_name"], $filePath)) {
        // アップロードに成功した場合は、ファイルパスをクライアントに返す
        echo json_encode(array("success" => true, "filePath" => $filePath));
    } else {
        // アップロードに失敗した場合はエラーメッセージを返す
        echo json_encode(array("success" => false, "message" => "ファイルのアップロードに失敗しました"));
    }
  } else {
      // ファイルがアップロードされなかった場合はエラーメッセージを返す
      echo json_encode(array("success" => false, "message" => "ファイルがアップロードされませんでした"));
  }
?>