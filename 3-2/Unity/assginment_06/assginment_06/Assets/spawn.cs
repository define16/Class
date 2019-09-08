using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class spawn : MonoBehaviour {
	public GameObject pf_wall;
	public float interval;
	float pos;
	// Use this for initialization
	IEnumerator Start () {
		while(true)
		{
			interval = Random.Range (1.0f,2.0f);
			pos =  Random.Range (-3.0f,3.0f);
			Instantiate (pf_wall, new Vector3(transform.position.x, pos , transform.position.z), transform.rotation);
			yield return new WaitForSeconds (interval);
		}
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
