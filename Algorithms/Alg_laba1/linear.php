<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <form method="get">
            <input type = "text" placeholder="Значание a" name ="a">
            <input type = "text" placeholder="Значание z" name="z">
            <hr>
            <input type="submit" value="Посчитать">
        </form>
        <hr>
        <form action="" method="POST" enctype="multipart/form-data">
            <input type="file" name="upload" />
            <input type="submit"/>
            <ul>
                <li>Sent file: <?php echo $_FILES['upload']['name'];  ?>
                <li>File size: <?php echo $_FILES['upload']['size'];  ?>
                <li>File type: <?php echo $_FILES['upload']['type']; ?>
                <li>File text: <?php echo file_get_contents($_FILES['upload']['tmp_name']); ?>
            </ul>
        </form>
        <hr>
        <?php
        /*
        y = [a-z] + [a+z]/6
        * введення а
        * а>10 ? (y = 2a^2 +x) : (y = -4sqrt(a^2 +x) and y = 2a^2-xy)
        */
        if(!isset($_GET["a"])&&!isset($_GET["z"])) {
            ini_set('display_errors', 0);
            echo "<hr>ERROR!!<br> Please, input values<hr>";
        }  
        $a =  $_GET['a'];
        $z =  $_GET['z'];
        $y = (double)($_GET['a']-$_GET['z']) + (($_GET['a']+$_GET['z'])/6);
           echo "[a-z] + [a+z]/6 = ".$y;
           echo "<br><hr>($a-$z) + (($a+$z)/6) = ".$y;
           $lines_of_file = file("linear.txt");
           print_r($lines_of_file);
           json_encode($lines_of_file);
           print_r($lines_of_file);
            print("<br>".$lines_of_file[1]);
            $numbers = explode(" ",$lines_of_file[1]);
            echo "<br>";
            print_r($numbers);

            if(isset($_FILES['upload'])) {
                $errors = array();
                $file_name = $_FILES['upload']['name'];
                $file_size = $_FILES['upload']['size'];
                $file_tmp = $_FILES['upload']['tmp_name'];
                $file_type = $_FILES['upload']['type'];
                $file_ext = strtolower(end(explode('.', $_FILES['upload']['name'])));
                $extension = array("txt","doc");

                if (in_array($file_ext, $extension) === false) {
                    $errors[] = "extension not allowed, please choose a TXT file.";
                }

                if ($file_size > 2097152) {
                    $errors[] = 'File size must be excately 2 MB';
                }

                if (empty($errors) == true) {
                    move_uploaded_file($file_tmp, "files/" . $file_name);
                    echo "Success";
                } else {
                    print_r($errors);
                }

                while (($line = fgets($_FILES['upload']['tmp_name'])) !== false) {
                    echo $line;
                }
                $line = file_get_contents($_FILES['upload']['tmp_name']);
                echo "<br>TEXT = $line";
            }
        ?>
    </body>
</html>
