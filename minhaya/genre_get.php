<?php
include 'api.php';

$sql = "SELECT genre FROM quiz_table";
$result = $conn->query($sql);
// データを格納するための配列
$genre = array(); 
if ($result->num_rows > 0) {
  // 取得したデータを配列に格納
  while($row = $result->fetch_assoc()) {
      $genre[] = $row;
  }
} else {
  echo "0 results";
}

$conn->close();
//JSON形式でデータを送信
echo json_encode($genre);
?>