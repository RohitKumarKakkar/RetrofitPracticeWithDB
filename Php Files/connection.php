<?php

$connection = new mysqli("localhost","id15175565_retrofitdb","Kakkar@11022007","id15175565_retrofitdatabase");

if($connection){
	echo"Connection Successfull";
}else{
	echo "Connection Failure";
}

?>