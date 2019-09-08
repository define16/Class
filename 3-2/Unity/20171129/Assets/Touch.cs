using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Touch : MonoBehaviour {
	public AudioClip voice_01;
	public AudioClip voice_02;

	private Animator animator;
	private AudioSource uni_voice;

	private int motion_idol = Animator.StringToHash ("Base Layer.Idol");

	// Use this for initialization
	void Start () {
		//animator = GetComponent<Animator> ();
		animator = GetComponent<Animator>();
		uni_voice = GetComponent<AudioSource> ();
	}
	
	// Update is called once per frame
	void Update () {
		Ray ray;
		RaycastHit hit;
		GameObject hit_object;

		animator.SetBool ("Touch", false);
		animator.SetBool ("TouchHead", false);

		if (Input.GetMouseButton (0)) {

			ray = Camera.main.ScreenPointToRay (Input.mousePosition);
			Debug.DrawRay (Camera.main.transform.position, ray.direction, Color.blue);

			if (Physics.Raycast (ray, out hit, 100)) {
				hit_object = hit.collider.gameObject;
				Debug.Log ("Hit!");
				Debug.DrawLine (Camera.main.transform.position, hit.point, Color.red);

				if(hit_object.gameObject.tag == "Head"){
					animator.SetBool ("TouchHead", true);
					uni_voice.clip = voice_01;
					uni_voice.Play();
				}

				else if(hit_object.gameObject.tag == "Leg")
				animator.SetBool ("Touch", true);
				uni_voice.clip = voice_02;
				uni_voice.Play();
			}
		}

		if (animator.GetCurrentAnimatorStateInfo (0).fullPathHash == motion_idol)
			animator.SetBool ("Motion_Idle", true);
		else
			animator.SetBool ("Motion_Idle", false);

		if (Input.GetKeyDown (KeyCode.Alpha1)) {
			animator.SetBool ("Face_Happy", true);
			animator.SetBool ("Face_Angry", false);
		} else if (Input.GetKeyDown (KeyCode.Alpha2)) {
			animator.SetBool ("Face_Happy", false);
			animator.SetBool ("Face_Angry", true);
		}


	}
}
