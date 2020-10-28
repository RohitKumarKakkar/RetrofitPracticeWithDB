<?php

$name = $_POST['name'];
$email = $_POST['email'];
$password = $_POST['password'];
$phone = $_POST['phone'];
$dob = $_POST['dob'];

require_once("connection.php");

$sql = "INSERT INTO userdata(name,email,password,phone,dob) VALUES('$name','$email','$password','$phone','$dob')";
$res = mysqli_query($connection,$sql);
$check = mysqli_fetch_array($res);

if(isset($check)){
echo 'Success';
}else{
echo 'Fail';
}

mysqli_close($connection);

?>