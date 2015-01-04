<?php
echo '<title>Sending a mail</title>';
function checkOK($field)
{
if (eregi("\r",$field) || eregi("\n",$field)){
die("Invalid Input!");
}
}

$name=$_POST['name'];
checkOK($name);
$email=$_POST['email_send'];
checkOK($email);
$to=$_POST['email_rec'];
checkOK($email_rec);
$subject=$_POST['subject'];
checkOK($subject);
$comments=$_POST['comments'];
checkOK($comments);


$message="$name just sent you a message. It says:\n$comments\n\nTheir e-mail address was: $email";
if(mail($to,$subject,$message,"From: $email\n")) {
echo "Thanks for your message.";
} else {
echo "There was a problem sending the mail. Please check that you filled in the form correctly.";
}
?>