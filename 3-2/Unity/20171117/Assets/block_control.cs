using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class block_control : MonoBehaviour {
	public map_creator map_script = null;

	// Use this for initialization
	void Start () {
		map_script = GameObject.Find ("block_root").GetComponent<map_creator> ();
	}
	
	// Update is called once per frame
	void Update () {
		if (map_script.IsGone (gameObject))
			GameObject.Destroy (gameObject);
	}
}
