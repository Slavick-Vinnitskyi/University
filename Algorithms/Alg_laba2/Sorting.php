<?php
function insertionSort($arr, $length) {
    if(isset($_POST["sort"])) {
        // $length = count($arr);
        for ($i = 1; $i < $length; $i++) {
            $element = $arr[$i];
            $j = $i;
            while ($j > 0 && $arr[$j - 1] > $element) {
                //move value to right and key to previous smaller index
                $arr[$j] = $arr[$j - 1];
                $j = $j - 1;
            }
            //put the element at index $j
            $arr[$j] = $element;
        }
        return $arr;
    }
}
