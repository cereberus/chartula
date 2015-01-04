

<?php
 $pagetitle = "Chat";
 
 include_once("../menu.php");
 include("../header_global.php");
 //include("header.php");
?>


<?php
    // if( !empty($_POST['clear'])){
       // $my_file = 'file.txt';
       // if(is_file($my_file)){
    // unlink($my_file);
       // }
    // }
	

	
    if( !empty($_POST['chat'])){
    $newData = $_POST['chat'];
    $newData .= "<br>";
    $my_file = 'file.txt';
    $handle = fopen($my_file, 'a+') or die('Cannot open file:  '.$my_file);
    $data = fwrite($handle,$newData);
	}
	
	if( !empty($_POST['hyper_link'])){
    $newData_links = "<a href='".$_POST['hyper_link']."'>".$_POST['hyper_link']."</a>";
	  
	// $newData_links = "<a href=&quot;&quot;>";$_POST['hyper_link'];"</a>";
    $newData_links .= "<br>";
    $my_file_links = 'links.txt';
    $handle_links = fopen($my_file_links, 'a+') or die('Cannot open file:  '.$my_file_links);
    $data_links = fwrite($handle_links,$newData_links);
    }
	
    ?>
	
	
    <!DOCTYPE html>
    <html lang="en">
    <head>
       <meta charset="utf-8">
       <title>Chat</title>
       <script src="chat.js"></script>
	   
	   <style>
	   
label
{
width: 4em;
float: left;
margin-right: 0.5em;
display: block
}

input
{
display:block;
width:65px;
height:65px;

<!---
color: #781351;
background: #fee3ad;
border: 1px solid #781351
--->
}


.submit input
{
margin-left: 4.5em;
} 

.submit input
{
color: #000;
background: #ffa20f;
border: 2px outset #d7b9c9
} 
--->


	   
	   </style>
	   
    </head>
    <body>

	
       <form id="form1" method="post" action="">
             <textarea autofocus id="area2" rows="4" name="chat" cols="30"  placeholder="Type here..."></textarea>
             <br>
             <input type="submit" id="button" value="Send">
       </form>
       <form id="form1" method="post" action="">
       <!---	 <input type="submit" name="clear" id="button" value="Clear">    --->       
       </form>
	   
									<br>
	   
	    <form id="form1" method="post" action="">
             <textarea id="area2" rows="2" name="hyper_link" cols="30" placeholder="Paste your hyperlink here..."></textarea>
             <br>
             <input type="submit" id="button" value="Send">
       </form>
       <form id="form1" method="post" action="">
	   
       </form>
	  
									<br>
<!---	   
	   <form action="#">
<fieldset>
<legend>This is my form</legend>
<p><label for="name">Name</label> <input type="text" id="name" /></p>
<p><label for="e-mail">E-mail</label> <input type="text" id="e-mail" /><br /></p>
<p class="submit"><input type="submit" value="Submit" /></p>
</fieldset>
</form>
--->

       <hr>
    <h2>Messages:</h2>
									<br>	
    <?php

    $my_file = 'file.txt';
    if(is_file($my_file)){
    $handle = fopen($my_file, 'r') or die('Cannot open file:  '.$my_file);
    $data = fread($handle,filesize($my_file));
	
    echo nl2br($data);
	
    }
	
	
    ?>
	
	   <hr>
    <h2>Hyperlinks:</h2>

	  <?php

    $my_file_links = 'links.txt';
    if(is_file($my_file_links)){
    $handle_links = fopen($my_file_links, 'r') or die('Cannot open file:  '.$my_file_links);
    $data_links = fread($handle_links,filesize($my_file_links));
	
    echo nl2br($data_links);
	
    }
	
	
    
	//<textarea id="area2" rows="10" name="chat" cols="50" placeholder="Type here..."><a href=""></a> </textarea>
	?>
	
    <hr>
    </body>
    </html>