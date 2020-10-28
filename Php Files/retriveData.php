<?php

$con=mysqli_connect("localhost","id15175565_retrofitdb","Kakkar@11022007","id15175565_retrofitdatabase");

$sql = "SELECT * FROM userdata";

$res = mysqli_query($con,$sql);

$response = array();

while($row = mysqli_fetch_assoc($res)){
    $response[] = $row;
}
header('Content-Type:Application/json');
echo json_encode($response);
?>