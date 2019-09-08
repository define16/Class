using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class SimpleUDTHandler : MonoBehaviour, IUserDefinedTargetEventHandler {
	private UserDefinedTargetBuildingAbstractBehaviour target_building_behavior;
	private ObjectTracker object_tracker;
	private DataSet data_set;
	private bool is_udt_initalized = false;
	private ImageTargetBuilder.FrameQuality frame_quality = ImageTargetBuilder.FrameQuality.FRAME_QUALITY_NONE;

	public ImageTargetBehaviour image_target_template;

	// Use this for initialization
	void Start () {
		target_building_behavior = GetComponent<UserDefinedTargetBuildingAbstractBehaviour> ();
		if (target_building_behavior)
			target_building_behavior.RegisterEventHandler (this);
	}
	
	// Update is called once per frame
	public void OnInitialized () {
		object_tracker = TrackerManager.Instance.GetTracker<ObjectTracker> ();

		if (object_tracker != null) {
			data_set = object_tracker.CreateDataSet ();
			object_tracker.ActivateDataSet (data_set);
			is_udt_initalized = true;
		}		
	}


	public void OnFrameQualityChanged(ImageTargetBuilder.FrameQuality p_frame_quality){
		frame_quality = p_frame_quality;
		Debug.Log("Tracking Quality : " + p_frame_quality);
	}

	void OnGUI () {
		if (!is_udt_initalized)
			return;
		if (frame_quality == ImageTargetBuilder.FrameQuality.FRAME_QUALITY_HIGH ||
		   frame_quality == ImageTargetBuilder.FrameQuality.FRAME_QUALITY_MEDIUM) {
			if (GUI.Button (new Rect (Screen.width / 50, (int)(Screen.height / 50), 150, 100), "Build New Target"))
				BuildNewTarget ();
		}
	}

	private void BuildNewTarget() {
		string new_target_name = "My_User_Defined_Target";
		target_building_behavior.BuildNewTarget (new_target_name, image_target_template.GetSize ().x);
	}

	public void OnNewTrackableSource(TrackableSource p_trackable_source) {
		object_tracker.DeactivateDataSet (data_set);

		if (data_set.HasReachedTrackableLimit ()) {
			IEnumerable<Trackable> trackables = data_set.GetTrackables ();
			Trackable oldest = null;

			foreach (Trackable trackable in trackables)
				if (oldest == null || trackable.ID < oldest.ID)
					oldest = trackable;
			if (oldest != null)
				data_set.Destroy (oldest, true);
		}
		ImageTargetBehaviour image_target_copy = (ImageTargetBehaviour)Instantiate (image_target_template);
		data_set.CreateTrackable (p_trackable_source, image_target_copy.gameObject);
		object_tracker.ActivateDataSet (data_set);
	}
}