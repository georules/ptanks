<?php
include_once './epiphany/src/Epi.php';
Epi::setPath('base', './epiphany/src');
Epi::init('api','database');

EpiDatabase::employ('mysql','ptanks'

getRoute()->get('/', 'showEndpoints');
getRoute()->post('/code','code');
getRoute()->run();

function showEndpoints()
{
	echo "hi";
}

function code()	{

}

?>
