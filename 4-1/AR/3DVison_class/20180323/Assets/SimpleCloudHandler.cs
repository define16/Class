using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class SimpleCloudHandler : MonoBehaviour, ICloudRecoEventHandler {
	private CloudRecoBehaviour cloud_reco_behaviour;
	private bool is_scanning = false;
	private string target_metadata;
	public ImageTargetBehaviour image_target_template;

	// Use this for initialization
	void Start () {
		cloud_reco_behaviour = GetComponent<CloudRecoBehaviour>();
		if (cloud_reco_behaviour)
			cloud_reco_behaviour.RegisterEventHandler (this);
	}

	public void OnInitialized(){
		Debug.Log ("Cloud Reco Initialted");
	}
	public void OnInitError(TargetFinder.InitState init_error){
		Debug.Log ("Cloud Reco init Error : " + init_error);
	}
	public void OnUpdateError(TargetFinder.UpdateState update_error){
		Debug.Log ("Cloud Reco update Error : " + update_error);
	}
	public void OnStateChanged(bool scanning)
	{
		is_scanning = scanning;
		if (is_scanning) {
			ObjectTracker target = TrackerManager.Instance.GetTracker<ObjectTracker> ();
			target.TargetFinder.ClearTrackables (false);
		}
	}

	public void OnNewSearchResult(TargetFinder.TargetSearchResult target_search_result){
		target_metadata = target_search_result.MetaData;
		cloud_reco_behaviour.CloudRecoEnabled = false;

		Debug.Log ("MetaData: " + target_metadata);
		if (image_target_template) {
			ObjectTracker tracker = TrackerManager.Instance.GetTracker<ObjectTracker> ();
			ImageTargetBehaviour image_target_beviour = (ImageTargetBehaviour)tracker.TargetFinder.EnableTracking (target_search_result, image_target_template.gameObject);
		}
	}

	void OnGUI() {
		GUI.Box (new Rect (100, 100, 200, 50), is_scanning ? "Scanning" : "Not Scanning");
		GUI.Box (new Rect (100, 200, 200, 50), "Metadata : " + target_metadata);

		if (!is_scanning)
		if (GUI.Button (new Rect (100, 300, 200, 50), "Restart Scanning"))
			cloud_reco_behaviour.CloudRecoEnabled = true;

	}
		
}
