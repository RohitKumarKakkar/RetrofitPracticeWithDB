<?php

$id = $_POST['id'];

require_once("connection.php");

$sql = "DELETE FROM userdata WHERE id = '$id' ";

$res = mysqli_query($connection,$sql);

if($res){
echo 'Success';
}else{
echo 'Fail';
}

mysqli_close($connection);

?>