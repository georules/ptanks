<?php
require_once('./config.php');
include_once './epiphany/src/Epi.php';
Epi::setPath('base', './epiphany/src');
Epi::init('api','database','debug');
Epi::setSetting('debug',true);

EpiDatabase::employ(DBTYPE,DBNAME,DBHOST,DBUSER,DBPASS);

getRoute()->get('/','show');
getRoute()->get('/(\d+)', 'show');
getRoute()->post('/code','code');
getRoute()->run();

function show($id = null)	{
	if (empty($id))	{
		$data = getDatabase()->all("SELECT * from code");
		var_dump($data);
	}
	else	{
		$code = getDatabase()->one("SELECT code FROM code WHERE id = :id", array('id'=>$id));
		$code = $code['code'];
		echo($code);
	}
}

function code()	{
	$code = $_POST['code'];
	getDatabase()->execute("INSERT INTO code (code) VALUES (:code)",array('code'=>$code));
}

?>
