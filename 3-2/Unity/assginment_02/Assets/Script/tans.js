#pragma strict

var speed  = 5;
var power = 500;
var ball: GameObject;

function Start () {
	
}

function Update () {
	var distance_per_frame = speed * Time.deltaTime;
	var ver = Input.GetAxis("Vertical");
	var hor = Input.GetAxis("Horizontal");

	transform.Translate(Vector3.forward * ver * distance_per_frame);
	transform.Translate(Vector3.right * hor * distance_per_frame);

	if(Input.GetButtonDown("Fire1"))
		ball.GetComponent.<Rigidbody>().AddForce(Vector3(0,1,1) * power);
}
