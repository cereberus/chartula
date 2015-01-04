<?php
$iphone = strpos($_SERVER['HTTP_USER_AGENT'],"iPhone");
$android = strpos($_SERVER['HTTP_USER_AGENT'],"Android");
$palmpre = strpos($_SERVER['HTTP_USER_AGENT'],"webOS");
$berry = strpos($_SERVER['HTTP_USER_AGENT'],"BlackBerry");
$ipod = strpos($_SERVER['HTTP_USER_AGENT'],"iPod");

if ($iphone == true) 
{
    echo "i am iphone";
 }
elseif ($android == true)
 {
     echo "i am android";
 }
 elseif ($palmpre == true)
 {
     echo "i am palmpre";
 }
 elseif ($ipod == true)
 {
     echo "i am ipod";
 }
 elseif ($berry == true)
 {
     echo "i am berry";
 }
 else
  {
     echo "i am not mobile";
 }
?>