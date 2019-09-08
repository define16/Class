using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class janken : MonoBehaviour {
	public AudioClip voice_janken_start;
	public AudioClip voice_janken_choki;
	public AudioClip voice_janken_goo;
	public AudioClip voice_janken_par;
	public AudioClip voice_janken_pon;
	public AudioClip voice_janken_win;
	public AudioClip voice_janken_lose;
	public AudioClip voice_janken_draw;


	const int JANKEN = 0;
	const int GOO = 1;
	const int CHOKI = 2;
	const int PAR = 3;
	const int DRAW = 4;
	const int WIN = 5;
	const int LOSE = 6;

	private Animator animotor;

	private AudioSource uni_voice;
	int my_hand;
	int unity_hand;
	int janken_result;

	float wait_time;

	int mode_janken = 0;
	bool is_janken = false;

	void OnGUI(){
		if (is_janken == false) {
			if (GUI.Button (new Rect (50, Screen.height - 150, 100, 100), "가위바위보"))
				is_janken = true;
		} else if (mode_janken == 1) {
			if (GUI.Button (new Rect (Screen.width / 2 - 120, 380, 100, 100), "가위")) {
				my_hand = CHOKI;
				mode_janken++;
			}
			if (GUI.Button (new Rect (Screen.width /2 , 380, 100, 100), "바위")) {
				my_hand = GOO;
				mode_janken++;
			}
			if (GUI.Button (new Rect (Screen.width / 2 + 120, 380, 100, 100), "보")) {
				my_hand = PAR;
				mode_janken++;
			}
		}
	}
	// Use this for initialization
	void Start () {
		animotor = GetComponent<Animator> ();
		uni_voice = GetComponent<AudioSource> ();
	}
	
	// Update is called once per frame
	void Update () {
		if (is_janken) {
			switch (mode_janken) {
			case 0:
				UnityChanAction (JANKEN);
				mode_janken++;
				break;
			case 1:
				break;
			case 2:
				janken_result = -1;
				unity_hand = Random.Range (GOO, PAR + 1);
				UnityChanAction (unity_hand);

				if (my_hand == unity_hand)
					janken_result = DRAW;
				else {
					janken_result = WIN;
					switch (unity_hand) {
					case CHOKI:
						if (my_hand == GOO)
							janken_result = LOSE;
						break;
					case GOO:
						if (my_hand == PAR)
							janken_result = LOSE;
						break;
					case PAR:
						if (my_hand == CHOKI)
							janken_result = LOSE;
						break;
					}
				}
				mode_janken++;
				break;
			case 3:
				wait_time += Time.deltaTime;
				if (wait_time > 1.5) {
					UnityChanAction (janken_result);
					wait_time = 0;
					is_janken = false;
					mode_janken = 0;
				}
				break;
			}
		}

	}

	void UnityChanAction(int action){
		switch (action) {
		case JANKEN:
			animotor.SetBool ("Janken", true);
			uni_voice.clip = voice_janken_start;
			break;
		
		case GOO:
			animotor.SetBool ("Goo", true);
			uni_voice.clip = voice_janken_goo;
			break;

		case CHOKI:
			animotor.SetBool ("Choki", true);
			uni_voice.clip = voice_janken_choki;
			break;
		
		case PAR:
			animotor.SetBool ("Par", true);
			uni_voice.clip = voice_janken_par;
			break;

		case DRAW:
			animotor.SetBool ("Aiko", true);
			uni_voice.clip = voice_janken_draw;
			break;

		case WIN:
			animotor.SetBool ("Win", true);
			uni_voice.clip = voice_janken_win;
			break;

		case LOSE:
			animotor.SetBool ("Lose", true);
			uni_voice.clip = voice_janken_start;
			break;
		}

		uni_voice.Play ();
	}
}
