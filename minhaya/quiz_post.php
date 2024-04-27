<?php
include 'api.php';

// データを受け取る
$image_path = $_POST['file_path'];
$genre = $_POST['genre'];
$question = $_POST['question'];
$answer = $_POST['answer'];

// SQL文を作成して実行
if ($image_path != "" && $genre != "" && $question != "" && $answer != ""){
  $sql = "INSERT INTO quiz_table (image_path, genre, question, answer) VALUES ('$image_path', '$genre', '$question', '$answer')";
  if ($conn->query($sql) === TRUE) {
    echo "New record created successfully";
  } else {
    echo "Error: " . $sql . "<br>" . $conn->error;
  }
} else {
  echo "post data is not satisfied. Please check data.";
}

$conn->close();
?>
