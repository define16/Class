using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class interaction : MonoBehaviour {
	public static Color defaultColor;
	public static Color began_color;
	public static Color end_color;
	public static Color stay_color;
	public static Material mat;

	// Use this for initialization
	void Start () {
		mat = GetComponent < Renderer ().material;

		mat.SetFloat ("_Mode", 2);
		mat.SetInt ("_SrcBlend", (int)UnityEngine.Rendering.BlendMode.SrcAlpha);
		mat.SetInt ("_DstBlend", (int)UnityEngine.Rendering.BlendMode.OneMinusSrcAlpha);
		mat.SetInt ("_ZWrite", 0);
		mat.DisableKeyword ("_ALPHATEST_ON");
		mat.EnableKeyword ("_ALPHABLEN_ON");
		mat.DisableKeyword ("_ALPHAPREMULTIPLY_ON");
		mat.renderQueue = 3000;

		defaultColor = new Color32 (255, 255, 255, 255);
		began_color = new Color32 (255, 0, 0, 255);
		end_color = new Color32 (0, 255, 0, 255);
		stay_color = new Color32 (0, 0, 255, 255);

		mat.color = defaultColor;
	}
	
	// Update is called once per frame
	void touchBegan () {
		Debug.Log ("Touch began");
		mat.color = began_color;
	}
	void touchEnded () {
		Debug.Log ("Touch began");
		mat.color = end_color;
	}
	void touchStay () {
		Debug.Log ("Touch began");
		mat.color = stay_color;
	}
	void touchExit() {
		Debug.Log ("Touch began");
		mat.color = defaultColor;
	}

}
