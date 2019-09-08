using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class RotatePlanet : MonoBehaviour {
	private Transform tr;
	public Transform target_tr;
	public float rpt_speed = 35.0f;

	// Use this for initialization
	void Start () {
		tr = GetComponent<Transform> ();

	}
	
	// Update is called once per frame
	void Update () {
		tr.RotateAround(target_tr.position, Vector3.up, Time.deltaTime * rpt_speed);
	}
}
