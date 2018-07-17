<?php
function fillArray() {
    if (isset($_GET["capacity"]) && isset($_GET["generate"])) {
        $array = array();

        for ($i = 0; $i < $_GET["capacity"]; $i++) {

            array_push($array, mt_rand(1, 10));
        }

        return $array;
    }
}
