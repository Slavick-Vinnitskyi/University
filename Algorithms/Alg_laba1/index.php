<html>
<head>
    <meta charset="UTF-8">
    <title>1 Лабораторна</title>
</head>
    <body>
    <form action = "" method = "post">
        <ul class="form-style-1">
            <li>
                <label>Числа</label>
                <input type = "text" name = "field1" class = "field-divided"/>
            </li>
            <li>
                <label>Тип алгоритму</label>
                <select class = "select" name = "order_algorithm">
                    <option value = "linear"> Лінійний </option>
                    <option value = "branching"> Розгалуджений </option>
                    <option value = "cycling"> Циклічний </option>
            </li>
            <li>
                <input type = "submit" value = "Порахувати" name = "string"/>
                <input type = "file" name = "user_file" style = "width:200px" style = "height:130px">
                <input type = "submit" value = "З файлу" name = "read">
            </li>
        </ul>
    </form>


<?php
        ini_set('display_errors', 1);
        $type = $_POST['order_algorithm'];
        $str_numbers = $_POST['field1'];
        if(isset($_FILES) && isset($_POST['read'])) {
            $file = file_get_contents('test.txt', true); {

                $file_arr = explode(";",$file);
                $a_1 = $file_arr[0];
                $z_1 = $file_arr[1];
                $y_1 = ($a_1 - $z_1) + ($a_1 + $z_1) / 6;
                echo " <b>Відповідь :</b> a = $a_1; z = $z_1 => y = $y_1</output>";
            }
        }

        if(isset($_POST["string"]) && isset($type)) {
            switch ($type) {
                case 'linear' :

                    echo "<output><b>Linear</b><br>y = [a-z] + [a+z]/6<br>";
                    $numbers = explode(";", $str_numbers);
                    $a = $numbers[0];
                    $z = $numbers[1];
                    $y = ($a - $z) + ($a + $z) / 6;
                    echo " <b>Відповідь :</b><br>a = $a; z = $z => y = $y</output>";

                    break;

                case 'branching' :

                    echo "<output><b>Branching</b><br>";
                    $numbers_br = explode(";", $str_numbers);
                    $a = $numbers_br[0];
                    $x = $numbers_br[1];
                    if ($a > 10) {
                        $y = 2 * pow(2, $a) + $x;
                        echo " <b>Відповідь :</b>a = $a(a > 10); x = $x => y = $y</output>";
                    } else {
                        $y = 2 * pow(2, $a) - $x;
                        $res = $y - 4 * sqrt(pow(2, $a) + $x);
                        echo " <b>Відповідь : </b>a = $a(a < 10); y = $y => Результат = $res</output>";
                    }
                    break;

                case 'cycling' :
                    echo "<output><b>Cycling</b><br>";
                    $numbers_cl = explode(";", $str_numbers);
                    $a_arr = array();
                    $b_arr = array();
                    $func = 1;
                    for ($i = 0; $i < 5; $i++) {
                        array_push($a_arr, $numbers_cl[$i]);
                    }
                    for ($i = 5; $i < 10; $i++) {
                        array_push($b_arr, $numbers_cl[$i]);
                    }
                    for ($i = 0; $i < 5; $i++) {
                        $func *= (pow(3, $a_arr[$i]) - pow(2, $b_arr[$i])) / ($a_arr[$i] * $b_arr[$i]);
                    }
                    echo " <b>Відповідь : </b>a[5] = $a_arr[4]; b[5] = $b_arr[4] => Результат = $func</output>";

                    break;

                default :
                    echo "Select type of sort";
                    break;
            }
        }
?>

    </body>
    <link rel = "stylesheet" href = "css/main.css">
</html>

