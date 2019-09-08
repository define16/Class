using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class drone_move : MonoBehaviour {
	
	//public GameObject marker_goal;
	GameObject marker_goal; // 수정한 부분
	public UnityEngine.AI.NavMeshAgent agent;
	Vector3 parent_position;

	// Use this for initialization
	void Start () {

	}
	
	// Update is called once per frame
	void Update () {
		MoveToTarget ();
		PitchCtrl ();
	}

	void MoveToTarget() {
		parent_position = marker_goal.transform.position;
		Debug.Log (parent_position);
		agent.SetDestination (parent_position);
	}
	float MapRange(float s, float a1, float a2, float b1, float b2) {
		if (s >= a2)
			return b2;
		if (s <= a1)
			return b1;

		return b1 + (s - a1) * (b2 - b1) / (a2 - a1);
	}

	void PitchCtrl(){
		transform.eulerAngles = new Vector3 (
			MapRange(agent.velocity.magnitude, 0f, 2f, 0f, 20f),
			transform.eulerAngles.y,
			transform.eulerAngles.z
		);
	}
	// 수정한 부분
	public void setMarker_goal(GameObject m) {
		marker_goal = m;
	}
	//

}
