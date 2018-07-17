<?php
/**
 *
 * Метод половинного ділення
 * $x^3 + 2x - 4 = 0
 * 1.180
 * Функція зростаюча
 *
 * @param $x
 * @return float|int
 */
function f($x) {
    $y = $x**3 + 2*$x - 4;
    return $y;

}
function n ($x1, $x2) {
    if ( f($x1) * f($x2) > 0) {
        return error_log("Корней нет");
    }

    $x = ($x2 + $x1)/2;

    while(abs(f($x)) > 0.1) {
        if(f($x) > 0) {
            $x2 = $x;
        }
        else {
            $x1 = $x;
        }
        $x = ($x2 + $x1)/2;
    }
    return $x;
}


