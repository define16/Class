using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class time : MonoBehaviour {
	float timer;
	public float jump;
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		timer += Time.deltaTime;
		jump = play.jump_player;
	}

	void OnGUI() {
		GUI.Label(new Rect (10,10,200,120), "플레이시간 : " + timer);
		GUI.Label(new Rect (10,30,200,120), "점프력 : " + jump);
	}
}
