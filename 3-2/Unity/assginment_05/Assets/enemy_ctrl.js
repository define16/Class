#pragma strict

private var power = 1200;


var bullet: Transform;
var target: Transform;
var sp_point: Transform;
private var elapsed_time : float = 0.0;
public var fire_interval : float =2.0;
static var time = 0.0f;

function Start () {

}

function Update () {
	transform.LookAt(target);
	elapsed_time += Time.deltaTime;

	var hit: RaycastHit;
	var fwd = transform.TransformDirection(Vector3.forward);
	Debug.DrawRay(sp_point.transform.position, fwd * 5, Color.red);
	if(Physics.Raycast(sp_point.transform.position, fwd, hit, 5) == false || hit.collider.gameObject.tag != "Tank" 
	|| elapsed_time < fire_interval){
		return;
		Debug.Log(hit.collider.gameObject.name);
	}
	var enemy_bullet = Instantiate(bullet, sp_point.transform.position, Quaternion.identity);
	enemy_bullet.GetComponent.<Rigidbody>().AddForce(fwd * power);
	elapsed_time = 0.0;

}
