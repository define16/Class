using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class ball_Shoot : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		
	}


	void OnCollisionEnter(Collision coll){
		GameObject cube = GameObject.Find("Cube") as GameObject;
		if(coll.gameObject == cube)
			GetComponent<Rigidbody>().AddForce(new Vector3 (0, 0, 1 * 10000));
	}
}
