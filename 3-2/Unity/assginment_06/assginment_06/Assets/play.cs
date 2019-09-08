using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;


public class play : MonoBehaviour {
	public static float jump_player;
	// Use this for initialization
	void Start () {
		jump_player = Random.Range (3.0f, 10.0f);
	}

	// Update is called once per frame
	void Update () {
		if (Input.GetKey ("space"))
			GetComponent<Rigidbody> ().velocity = new Vector3 (0.0f, jump_player, 0.0f);
	}

	void OnCollisionEnter(Collision other) {
		SceneManager.LoadScene ("main_scene");
	}
}
