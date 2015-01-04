<!DOCTYPE html>

<?php 
    $pagetitle = "Base";
    include("../header_global.php");
    include_once("../menu.php");
?>

<br>

<?php
if ($handle = opendir('.')) {
     while (false !== ($entry = readdir($handle))) {
         if ($entry != "." && $entry != "..") {
             echo "$entry\n";
             echo "<br>";
         }
     }
     closedir($handle);
}
?>

<br>
<br>


