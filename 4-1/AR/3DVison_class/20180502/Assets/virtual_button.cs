using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class virtual_button : MonoBehaviour, IVirtualButtonEventHandler {
	public GameObject anim_object;
	private GameObject vb_object;

	// Use this for initialization
	void Start () {
		vb_object = GameObject.Find ("VB_Hello");
		vb_object.GetComponent<VirtualButtonBehaviour> ().RegisterEventHandler (this);
		anim_object.GetComponent<Animation> ().Stop ();
	}

	public void OnButtonPressed(VirtualButtonAbstractBehaviour vb) {
		Debug.Log ("Button Pressed");
		anim_object.GetComponent<Animation> ().Play ();
	}

	public void OnButtonReleased(VirtualButtonAbstractBehaviour vb) {
		Debug.Log ("Button Released");
		anim_object.GetComponent<Animation> ().Stop();
	}

}
