using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using Vuforia;

public class camera_image : MonoBehaviour {
	private Image.PIXEL_FORMAT pixel_format = Image.PIXEL_FORMAT.RGBA8888;
	private bool is_format_registered = false;

	// Use this for initialization
	void Start () {
		VuforiaARController.Instance.RegisterVuforiaStartedCallback (OnVuforiaStarted);
		VuforiaARController.Instance.RegisterTrackablesUpdatedCallback (OnTrackablesUpdated);

	}
	
	void OnVuforiaStarted() {
		if (CameraDevice.Instance.SetFrameFormat (pixel_format, true)) {
			Debug.Log ("Sucessfully registered : " + pixel_format.ToString ());
			is_format_registered = true;
		} else {
			Debug.LogError ("Failed to register : " + pixel_format.ToString ());
			is_format_registered = false;
		}		

	}

	void OnTrackablesUpdated() {
		Texture2D tex_image;
		if(is_format_registered){
			Vuforia.Image cam_image = CameraDevice.Instance.GetCameraImage (pixel_format);

			if(cam_image != null) {
				Debug.Log("Image Format : " + cam_image.PixelFormat +"\nImage Size : " + cam_image.Width + "x" + cam_image.Height);
				byte[] pixels = cam_image.Pixels;

				if(pixels != null && pixels.Length > 0)
				{
					Debug.Log("Image Pixels : " + pixels[0] + ", " + pixels[1] + ", " + pixels[2] + ", ...");
				}
			}
		}
	}
	
}
