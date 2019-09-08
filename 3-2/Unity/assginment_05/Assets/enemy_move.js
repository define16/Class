#pragma strict

static var rot_angle = 15;

function Start () {
	
}

function Update () {
	var current_angle = rot_angle * Time.deltaTime;

	transform.RotateAround(Vector3.zero, Vector3.up, current_angle);
}
