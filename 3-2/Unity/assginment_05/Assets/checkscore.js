#pragma strict

static var hit = 0;
static var lose = 0;

function Start () {
	
}

function Update () {
	
}

function OnGUI() {
	GUI.Label(Rect(10,10,120,120), "Hit : " + hit);
	GUI.Label(Rect(10,30,120,120), "lose : " + lose);
}