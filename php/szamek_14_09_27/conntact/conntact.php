<html>
 <head>
  <title>Conntact us</title>
		<link rel="stylesheet" href="/_css/mainstyle.css" type="text/css">
		<?php
 		include("../header_global.php");
		?>

 </head>
 <body>
<?php
include_once("../menu.php");
echo "<br>";
?>

<h3></h3>

<br>

<form action="mail.php" method="post">
Your Name:
<br> 
<input type="text" name="name">
<br>
E-mail send by: 
<br>
<input type="text" name = "email_send">
<br>
E-mail receiver:
<br>
<input type="text" name = "email_rec">
<br>
<br>
Subject: 
<br>
<input type="text" name = "subject">
<br>
Message
<br>
<textarea name="comments"></textarea><br><br>
<input type="submit" value="Submit message">
</form>




 
 </body>
</html>