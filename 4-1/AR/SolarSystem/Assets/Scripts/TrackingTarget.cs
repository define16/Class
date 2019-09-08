using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class TrackingTarget : MonoBehaviour, ITrackableEventHandler {

	private TrackableBehaviour track;

	[SerializeField]
	private RotatePlanet[] scripts;

	// Use this for initialization
	void Start () {
		scripts = GameObject.FindObjectsOfType<RotatePlanet> ();
		track = GetComponent<TrackableBehaviour> ();

		if (track) {
			track.RegisterTrackableEventHandler (this);
		}
	}

	void OnDisable(){
		track.UnregisterTrackableEventHandler (this);
	}

	public void OnTrackableStateChanged(TrackableBehaviour.Status previousStatus, 
		TrackableBehaviour.Status newStatus){

		if (newStatus == TrackableBehaviour.Status.DETECTED || newStatus == TrackableBehaviour.Status.TRACKED
		    || newStatus == TrackableBehaviour.Status.EXTENDED_TRACKED) {

			ScriptEnable (true);
		} else {
			ScriptEnable (false);
		}

	}

	void ScriptEnable(bool _enabled) {
		foreach (var script in scripts) {
			script.enabled = _enabled;
		}
	}
	// Update is called once per frame
	void Update () {
		
	}
}
