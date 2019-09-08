#pragma strict

import UnityEngine.SceneManagement;

function Start () {
	checkscore.hit = 0;
	checkscore.lose = 0;
	enemy_move.rot_angle = 15;
	move.tank_speed = 5;
}

function Update () {
	if(Input.anyKeyDown)
		SceneManager.LoadScene("20171013");
}
