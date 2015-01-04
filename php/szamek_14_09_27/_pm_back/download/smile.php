<?php
header('Content-disposition: attachment; filename=smile.pdf');
header('Content-type: application/pdf');
readfile('smile.pdf');
?>