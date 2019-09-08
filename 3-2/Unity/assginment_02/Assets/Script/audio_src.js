#pragma strict

function Start () {
	
}

function Update () {
	
}

function OnCollisionEnter(coll: Collision)	{
	GetComponent.<AudioSource>().Play();
}
