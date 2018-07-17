<?php
include_once "index.php";

$arrayx = array();
for($i = 0; $i < 11; $i++) {
    for ($j = -5; $j < 5; $j++) {
        array_push($arrayx, $j);

    }
    echo $arrayx[$i] . " ";
}

$arrayy = array();
echo "<br>";

for($i = 0; $i < 11; $i++) {

        $element = $arrayx[$i]**3 + $arrayx[$i]*2 -4;
        array_push($arrayy,$element);
        echo $arrayy[$i] . " ";

}
$data = array(
    '0' => array(),
    '1' => array()
);
for ($i = 0; $i < 5; $i++) {
    array_push($data['0'],$arrayx[$i]);
    array_push($data['1'],$arrayy[$i]);
}
$dataPoints1 = array(
    array("x"=> $arrayx[0],	    "y"=> $arrayy[0]),
    array("x"=> $arrayx[1],	"y"=> $arrayy[1]),
    array("x"=> $arrayx[2],	"y"=> $arrayy[2]),
    array("x"=> $arrayx[3],	"y"=> $arrayy[3]),
    array("x"=> $arrayx[4],	"y"=> $arrayy[4]),
    array("x"=> $arrayx[5],	"y"=> $arrayy[5]),
    array("x"=> $arrayx[6],	"y"=> $arrayy[6]),
    array("x"=> $arrayx[7],	"y"=> $arrayy[7]),
    array("x"=> $arrayx[8],	"y"=> $arrayy[8]),
    array("x"=> $arrayx[9],	"y"=> $arrayy[9]),
    array("x"=> $arrayx[10],	"y"=> $arrayy[10])
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
                    text: "x^3 + 2 x - 4"
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

<p align="center"><b>Знайдений корінь :</b><?php echo n(-100,100);?></p>

</body>
</html>