<!DOCTYPE html>


<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> 
    
    <?php
    $pagetitle = "Chat";
    
    include("../header_global.php");
    
    ?>
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

}
       
    </style>
  
    <?php

	
    if( !empty($_POST['chat'])){
    $newData = $_POST['chat'];
    $newData .= "<br>";
    $my_file = 'file.txt';
    $handle = fopen($my_file, 'a+') or die('Cannot open file:  '.$my_file);
    $data = fwrite($handle,$newData);
	}
	
	if( !empty($_POST['hyper_link'])){
    $newData_links = "<a href='".$_POST['hyper_link']."'>".$_POST['hyper_link']."</a>";
	  
	// $hyper_link_description = $_POST['hyper_link_description'];
    $newData_links .= "<br>";
    $my_file_links = 'links.txt';
    $handle_links = fopen($my_file_links, 'a+') or die('Cannot open file:  '.$my_file_links);
    $data_links = fwrite($handle_links,$newData_links);
    // $data_links = fwrite($handle_links,$hyper_link_description,$newData_links);
    }
	
    ?>


</head>

<body>
    
    <?php
            include_once("../menu.php");
    ?>
    
    
    <form id="form1" method="post" action="">
        <textarea autofocus id="area1" rows="4" name="chat" cols="30"  placeholder="Type here..."></textarea>
        <br>
        <input type="submit" id="button" value="Chat&#x00A;Send">
    </form>
    <form id="form1" method="post" action="">
    <!---	 <input type="submit" name="clear" id="button" value="Clear">    --->       
    </form>
   
								
   
    <form id="form1" method="post" action="">
        <textarea id="area2" rows="2" name="hyper_link" cols="15" placeholder="Paste your hyperlink here..."></textarea>
        <textarea id="area2" rows="2" name="hyper_link_description" cols="15" placeholder="Paste the description of your hyperlink here..."></textarea>
        <br>
        <input type="submit" id="button" value="Link&#x00A;Send">
    </form>
    <form id="form1" method="post" action="">
   
    </form>
    
     
	  
									<br>


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
	
	
	?>
	
    <hr>
    </body>
    </html>