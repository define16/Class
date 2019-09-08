#pragma strict
//var collision_sound: AudioSource;
var explosion: Transform;
 

function OnTriggerEnter(other : Collider) {
		var pf_explosion = Instantiate(explosion, transform.position, transform.rotation);
	//	AudioSource.PlayClipAtPoint(collision_sound, transform.position);
		Destroy(gameObject);


	if(other.gameObject.tag =="Obstacle") {

		Destroy(other.gameObject);
	}
	else if(other.gameObject.tag =="enemy") {
		checkscore.hit++;
		enemy_move.rot_angle *= 0.9;
		Debug.Log("적군"+enemy_move.rot_angle);
		if(checkscore.hit>5) {
			Destroy(other.transform.root.gameObject);
			SceneManager.LoadScene("win_screen");
		}
	}	
	else if(other.gameObject.tag =="Tank") {
		checkscore.lose++;
		move.tank_speed *= 0.9;
		Debug.Log("아군"+move.tank_speed);
		if(checkscore.lose>5) {
			Destroy(other.transform.root.gameObject);
			SceneManager.LoadScene("lose_screen");
		}
	}


}

/// 마지막 포탄이 생성된 후 5초가 지면 메모리에서 제거 문제를 2가지 방법으로 적었습니다.
function Start () {
	//Destroy(gameObject,5);	//1번째 방법
}
function Update () {
	if(move.time > 5)	//2번째 방법
		Destroy(gameObject);
}