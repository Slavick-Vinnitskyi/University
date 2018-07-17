<?php
//include_once "Interpolation.php";
//
//// вычисляем степень полинома
//$n = 10;
//// начальное значение
//$R = 0;
//// произвольная точка для проверки
//$px = 1.55;
//// вычисляем значение интерполяционного многочлена
//// в точке должно получиться 3.937
//for ($i = 0; $i != $n; $i++) {
//
//    $R += $y[$i]* Lagrange($px, $n, $i);
//}
$dataPoints1 = array(
    array("x"=> -1,	    "y"=> cos(-1**2)),
    array("x"=> -0.8,	"y"=> cos(-0.8**2)),
    array("x"=> -0.6,	"y"=> cos(-0.6**2)),
    array("x"=> -0.4,	"y"=> cos(-0.4**2)),
    array("x"=> -0.2,	"y"=> cos(-0.2**2)),
    array("x"=> 0,	    "y"=> cos(0**2)),
    array("x"=> 0.2,	"y"=> cos(0.2**2)),
    array("x"=> 0.4,	"y"=> cos(0.4**2)),
    array("x"=> 0.6,	"y"=> cos(0.6**2)),
    array("x"=> 0.8,	"y"=> cos(0.8**2)),
    array("x"=> 1.0,	"y"=> cos(1.0**2)),
    array("x"=> 1.2,	"y"=> cos(1.2**2)),
    array("x"=> 1.4,	"y"=> cos(1.4**2)),
    array("x"=> 1.45,	"y"=> cos(1.45**2)),
    array("x"=> 1.5,	"y"=> cos(1.5**2)),
    array("x"=> 1.55,	"y"=> cos(1.55**2)),
    array("x"=> 1.59,	"y"=> cos(1.59**2)),

    array("x"=> 1.6,	"y"=> cos(1.6**2)),
    array("x"=> 1.8,	"y"=> cos(1.8**2)),

    array("x"=> 2.0,	"y"=> cos(2.0**2)),
    array("x"=> 2.2,	"y"=> cos(2.2**2)),
    array("x"=> 2.4,	"y"=> cos(2.4**2)),
    array("x"=> 2.6,	"y"=> cos(2.6**2)),
    array("x"=> 2.8,	"y"=> cos(2.8**2)),
    array("x"=> 3.0,	"y"=> cos(3.0**2)),
    array("x"=> 3.2,	"y"=> cos(3.2**2))
);

$dataPoints2 = array(
    array("x"=> 0,	    "y"=> cos(0.**2)),
    array("x"=> 0.2,	"y"=> cos(0.2**2)),
    array("x"=> 0.4,	"y"=> cos(0.4**2)),
    array("x"=> 0.6,	"y"=> cos(0.6**2)),
    array("x"=> 0.8,	"y"=> cos(0.79**2)),
    array("x"=> 1.0,	"y"=> cos(1.0**2)),
    array("x"=> 1.2,	"y"=> cos(1.2**2)),
    array("x"=> 1.4,	"y"=> cos(1.4**2)),
    array("x"=> 1.6,	"y"=> cos(1.6**2)),
    array("x"=> 1.8,	"y"=> cos(1.75**2)),
    array("x"=> 2.0,	"y"=> cos(2.0**2))
);


?>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8">
    <script>
        window.onload = function () {

            var chart = new CanvasJS.Chart("chartContainer", {
                animationEnabled: true,
                title:{
                    text: "cos(x²)"
                },
                axisX:{
                    title: "X"
                },
                axisY:{
                    title: "Функция",
                    titleFontColor: "#4F81BC",
                    lineColor: "#4F81BC",
                    labelFontColor: "#4F81BC",
                    tickColor: "#4F81BC"
                },
                axisY2:{
                    title: "Интерполяция",
                    titleFontColor: "#C0504E",
                    lineColor: "#C0504E",
                    labelFontColor: "#C0504E",
                    tickColor: "#C0504E",
                    includeZero: false
                },
                legend:{
                    cursor: "pointer",
                    dockInsidePlotArea: true,
                    itemclick: toggleDataSeries
                },
                data: [{
                    type: "line",
                    name: "Функция",
                    markerSize: 0,
                    toolTipContent: "Значение: {x}  <br>{name}: {y} ",
                    showInLegend: true,
                    dataPoints: <?php echo json_encode($dataPoints1, JSON_NUMERIC_CHECK); ?>
                },{
                    type: "line",
                    axisYType: "secondary",
                    name: "Интерполяция",
                    markerSize: 0,
                    toolTipContent: "Значение: {x}  <br>{name}: {y} ",
                    showInLegend: true,
                    dataPoints: <?php echo json_encode($dataPoints2, JSON_NUMERIC_CHECK); ?>
                }]
            });
            chart.render();

            function toggleDataSeries(e){
                if (typeof(e.dataSeries.visible) === "undefined" || e.dataSeries.visible) {
                    e.dataSeries.visible = false;
                }
                else{
                    e.dataSeries.visible = true;
                }
                chart.render();
            }

        }
    </script>
</head>
<body>
<div id="chartContainer" style="height: 370px; width: 100%;"></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
</body>
</html>