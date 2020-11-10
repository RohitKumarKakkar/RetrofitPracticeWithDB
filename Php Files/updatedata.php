<?php

$id = $_POST['id'];
$name = $_POST['name'];
$email = $_POST['email'];
$password = $_POST['password'];
$phone = $_POST['phone'];
$dob = $_POST['dob'];

require_once("connection.php");

$sql = "UPDATE userdata SET name = '$name' , email = '$email' , password = '$password' , phone = '$phone' , dob = '$dob' WHERE id = '$id' ";

$res = mysqli_query($connection,$sql);

if($res){
echo 'Success';
}else{
echo 'Fail';
}

mysqli_close($connection);

?>