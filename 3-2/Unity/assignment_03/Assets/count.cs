using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;

public class count : MonoBehaviour {

	private int cnt = 0; 
	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		if (cnt == 10) {
			SceneManager.LoadScene ("firstScreen", LoadSceneMode.Single);
		}
	}

	void OnCollisionEnter(Collision coll){
		cnt++;
	}

	void OnGUI() {
		GUI.Label (new Rect (81, Screen.height - 40, 128, 32), cnt.ToString ());
	}
}
