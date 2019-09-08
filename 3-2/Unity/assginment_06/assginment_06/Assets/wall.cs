using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class wall : MonoBehaviour {
	public float speed;
	// Use this for initialization
	void Start () {
		speed = Random.Range (-6.0f,-4.0f);
		Destroy (gameObject, 5.0f);
	}
	
	// Update is called once per frame
	void Update () {
		transform.Translate (speed * Time.deltaTime, 0.0f , 0.0f);
	}
}
