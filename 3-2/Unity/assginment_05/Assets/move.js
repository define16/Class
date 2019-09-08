#pragma strict

static var tank_speed = 5;
var rot_speed = 120;
var bullet_power = 600;

var turret: GameObject;
var bullet: Transform;
var barrel: GameObject;
static var time = 0.0f;

function Update () {
	var distance_per_frame = tank_speed * Time.deltaTime;
	var degrees_per_frame = rot_speed * Time.deltaTime;

	var moving_velocity = Input.GetAxis("Vertical");
	var tank_angle = Input.GetAxis("Horizontal");
	var turret_angle = Input.GetAxis("TurretRotation");

	transform.Translate(Vector3.forward * moving_velocity * distance_per_frame);
	transform.Rotate(Vector3(0, tank_angle * degrees_per_frame, 0));
	turret.transform.Rotate(Vector3.up * turret_angle * degrees_per_frame);

	if(Input.GetButtonDown("Fire1")) {
		var spawn_point = GameObject.Find("sp_bullet");
		var prefab_bullet = Instantiate(bullet, spawn_point.transform.position, spawn_point.transform.rotation);
		prefab_bullet.GetComponent.<Rigidbody>().AddForce(barrel.transform.up * bullet_power);
		time = 0.0f;
	}
	time += 1.0f * Time.deltaTime;
	Debug.Log("아군 time = " + time);

}

function Start () {

}
