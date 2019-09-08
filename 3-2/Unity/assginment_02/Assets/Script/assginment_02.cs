using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class assginment_02 : MonoBehaviour {
	
	public GameObject ball_shooter;
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		if(Input.GetKey(KeyCode.UpArrow))
			GetComponent<Rigidbody>().AddForce(Vector3.forward * 500 * Time.deltaTime);
		if(Input.GetKey(KeyCode.DownArrow))
			GetComponent<Rigidbody>().AddForce(Vector3.back * 500 * Time.deltaTime);
		if(Input.GetKey(KeyCode.LeftArrow))
			GetComponent<Rigidbody>().AddForce(Vector3.left * 500 * Time.deltaTime);
		if(Input.GetKey(KeyCode.RightArrow))
			GetComponent<Rigidbody>().AddForce(Vector3.right * 500 * Time.deltaTime);
		
	}
}
