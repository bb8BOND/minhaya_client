<?php
$servername = "localhost";
$username = "root";
$password = "";
$dbname = "quiz_db";

// MySQLに接続
$conn = new mysqli($servername, $username, $password, $dbname);

// 接続をチェック
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}
?>