<?php
     $startNum = 264360;
     $endNum = 746325;
     $desiredLength = 6;

//This Program returns a possible number of password combinations for the following rules:

//The password is within the range 264360 and 746325
//The password is six digits long
//The password should contain at least one set of adjacent number which are the same
//The next digit in the password can be equal to or greater than the previous digits but not less than the previous digits


//some examples:

//345677
//445667
//556789
//456785        this won't work as the last digit is greater than the second last

function validateSixDigits($num){
    global $desiredLength;
    $myString = strval($num);
    return ($desiredLength == strlen($myString));
}

function validateNumberWithinRange($num){
    global $startNum, $endNum;
    return $startNum < $num && $num < $endNum;
    }

function validateForSameAdjacentNumbers($num){
    $adjacent = false;
    $array = array_map('intval', str_split($num));
    for($i = 0; $i < count($array)-1; $i++){
        if ($array[$i] == $array[$i+1]){
            $adjacent = true;
            break;
        }
    }
    return $adjacent;
    }


function validateSequenceIncrement($num){
    $increasing = true;
    $array = array_map('intval', str_split($num));
    for($i = 0; $i < count($array)-1; $i++){
        if ($array[$i] > $array[$i+1]){
            $increasing = false;
            break;
        }
    }
     return $increasing;
    }


    $resultArray = array();
    for($i = $startNum; $i < $endNum; $i++){
        if (validateSixDigits($i) && validateNumberWithinRange($i) &&  validateSequenceIncrement($i) && validateForSameAdjacentNumbers($i)){
            array_push($resultArray, $i);

        }
    }
    echo count($resultArray);