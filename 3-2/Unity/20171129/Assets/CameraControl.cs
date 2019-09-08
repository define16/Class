using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CameraControl : MonoBehaviour {

	// Use this for initialization
	void Start () {
		
	}
	
	// Update is called once per frame
	void Update () {
		if (Input.GetMouseButton (0)) {
			Camera.main.transform.Translate (Input.GetAxisRaw ("Mouse X") / 10, Input.GetAxisRaw ("Mouse Y") / 10, 0);
		}
		if (Input.GetMouseButton (1)) {
			Camera.main.transform.Rotate (Input.GetAxisRaw ("Mouse Y") * 5, Input.GetAxisRaw ("Mouse X") * 5, 0);
		}

		Camera.main.fieldOfView += (20 * Input.GetAxis ("Mouse ScrollWheel"));
		if (Camera.main.fieldOfView < 10)
			Camera.main.fieldOfView = 10;
	}
}
