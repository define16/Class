using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class rigid_body : MonoBehaviour {

	// Use this for initialization
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
		if(Input.GetKey(KeyCode.U))
			GetComponent<Rigidbody>().AddForce(Vector3.up * 3000 * Time.deltaTime);
		if(Input.GetKey(KeyCode.D))
			GetComponent<Rigidbody>().AddForce(Vector3.down * 3000 * Time.deltaTime);
		
	}
}
