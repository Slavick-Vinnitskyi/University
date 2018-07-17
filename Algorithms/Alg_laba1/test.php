<?php
if(!empty($_POST["order_algorithm"])&&($_POST["order_algorithm"] == "linear" )) echo "<a href='linear.php'>Linear</a>"; ?>
<div id = "linear_form">
    <form method="get">
        <input type = "text" placeholder="Значание a" name ="a">
        <input type = "text" placeholder="Значание z" name="z">
        <hr>
        <input type="submit" value="Посчитать">
    </form>
</div>
<?php if (!empty($_POST['order_algorithm'])&&$_POST(['order_algorithm'] == "branching" ))echo "<a href='linear.php'>Linear</a>"; ?>
<div id = "branching_form">
    <form method="get">
        <input type = "text" placeholder="Значание a" name ="a">
        <input type = "text" placeholder="Значание z" name="z">
        <hr>
        <input type="submit" value="Посчитать">
    </form>
</div>
<?php if (!empty($_POST['order_algorithm'])&&$_POST(['order_algorithm'] == "cycling" )) echo "<a href='linear.php'>Linear</a>"; ?>
<div id = "cycling_form">
    <form method="get">
        <input type = "text" placeholder="Значание a" name ="a">
        <input type = "text" placeholder="Значание z" name="z">
        <hr>
        <input type="submit" value="Посчитать">
    </form>