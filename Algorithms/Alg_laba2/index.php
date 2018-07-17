<html>

<head>
    <meta charset = "UTF-8">
    <title>2 Лабораторна</title>
</head>
<body>
<form action = "" method = "get">
    <ul class = "form-style-1">
        <li>
            <label>Число елементів</label>
            <input type = "number" name="capacity" class = "field-divided"/>

            <input type = "submit" value = "Generate" name="generate">
            <!--<input type = "submit" value = "Sort" name="sort">-->
        </li>
    </ul>
</form>
<?php
    ini_set("display_errors",1);
    //include_once  "Sorting.php";
    include_once  "FillArray.php";

    // генерируем
    if (filter_input(INPUT_GET,"generate")) {
        echo "<p class='textout'><b>Згенерований масив : </b></p>";
        $array = fillArray();
        echo json_encode($array);
    }

    //выводим
    if (filter_input(INPUT_GET,"capacity")) {
        $size = filter_input(INPUT_GET, "capacity");
        echo "<p class='textout'><b>Його розмір :</b> $size</p><br>";
    }
    if (filter_input(INPUT_GET,"generate")) {
        //сортируем
        $start = microtime(true);

        sort($array, SORT_NUMERIC);

        $time = microtime(true) - $start;

        echo "<p class='textout'><b>Время выполнения :</b> $time секунд</p><p class='textout'><b>Відсортований масив : </b>". json_encode($array)."</p>";
    }

?>

</body>
<link rel="stylesheet" href="css/main.css">
</html>

