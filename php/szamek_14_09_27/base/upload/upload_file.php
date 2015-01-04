<?php

 
   $pagetitle = "File Upload";
  include("$_SERVER['SERVER_NAME']/header.php");	/*page title & background*/
  include("$_SERVER['SERVER_NAME']/header_global.php");



include_once("$_SERVER['SERVER_NAME']/menu.php");

 echo "<br>";
  echo "<br>";
  
  
  if ($_FILES["file"]["error"] > 0)
    {
    echo "Return Code: " . $_FILES["file"]["error"] . "<br>";
    }
  else
    {
    echo "Upload: " . $_FILES["file"]["name"] . "<br>";
    echo "Type: " . $_FILES["file"]["type"] . "<br>";
    echo "Size: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
    echo "Temp file: " . $_FILES["file"]["tmp_name"] . "<br>";

    if (file_exists("upload/" . $_FILES["file"]["name"]))
      {
      echo $_FILES["file"]["name"] . " already exists. ";
      }
    else
      {
      move_uploaded_file($_FILES["file"]["tmp_name"],
      "upload/" . $_FILES["file"]["name"]);
      echo "Stored in: " . "upload/" . $_FILES["file"]["name"];
	   echo "<br>";
	    echo "<br>";
	  include_once("back_head.php");
      }
	  
    }

?>
