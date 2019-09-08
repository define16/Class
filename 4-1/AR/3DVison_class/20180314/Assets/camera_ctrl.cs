using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class camera_ctrl : MonoBehaviour {
	int auto_focus_mode = 0;
	bool focus_mode_set = false;
	string focus_mode_name;

	bool is_front_camera = true;

	float distance = 0.0f;
	public TrackableBehaviour tracked_target;

	void Update() {
		Vector3 position_offset = tracked_target.transform.position - Camera.main.transform.position;
		distance = Mathf.Sqrt (position_offset.x * position_offset.x + position_offset.y * position_offset.y + position_offset.z * position_offset.z);
		Debug.Log (position_offset + " : " + distance);
	}

	void OnGUI(){
		if (auto_focus_mode == 0)
			focus_mode_name = "AUTO FOCUS";
		else if (auto_focus_mode == 1)
			focus_mode_name = "NORMAL FOCUS";

		if (GUI.Button (new Rect ((int)(Screen.width / 50), (int)(Screen.height / 50), 170, 30), "Set to " + focus_mode_name)) {
			focus_mode_set = false;
			auto_focus_mode = (1 - auto_focus_mode);

			if (auto_focus_mode == 0)
				focus_mode_set = CameraDevice.Instance.SetFocusMode (CameraDevice.FocusMode.FOCUS_MODE_NORMAL);
			else if (auto_focus_mode == 1)
				focus_mode_set = CameraDevice.Instance.SetFocusMode (CameraDevice.FocusMode.FOCUS_MODE_CONTINUOUSAUTO);

			if (!focus_mode_set)
				Debug.Log ("Failed to set camera focus mode!");
		}

		if (GUI.Button (new Rect ((int)(Screen.width / 50) + 200, (int)(Screen.height / 50), 170, 30), "Switch Direction"))
		{
			if (is_front_camera) {
				CameraDevice.Instance.Init (CameraDevice.CameraDirection.CAMERA_BACK);
				Debug.Log ("Rear camera is activated.");
				is_front_camera = false;
			}
				
			else {
				CameraDevice.Instance.Init (CameraDevice.CameraDirection.CAMERA_FRONT);
				Debug.Log ("Front camera is activated.");
				is_front_camera = true;
				}
		}
	}

}
