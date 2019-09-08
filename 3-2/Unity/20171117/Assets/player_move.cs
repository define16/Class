using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class player_move : MonoBehaviour {
	public static float ACCELEATION = 10.0f;
	public static float SPEED_MIN = 4.0f;
	public static float SPEED_MAX = 8.0f;
	public static float JUMP_HEIGHT_MAX = 3.0f;
	public static float JUMP_POWER_REDUCE = 3.5f;
	public static float FAIL_LIMIT = -5.0f;
	public enum STEP
	{
		NONE = -1,
		RUN = 0,
		JUMP,
		MISS,
		NUM,
	};

	public STEP step = STEP.NONE;
	public STEP next_step = STEP.NONE;

	public float step_timer = 0.0f;
	private bool is_landed = false;
	private bool is_collided = false;
	private bool is_key_released = false;

	// Use this for initialization
	void Start () {
		next_step = STEP.RUN;
	}
	
	// Update is called once per frame
	void Update () {
		//transform.Translate (new Vector3 (0.0f, 0.0f, 3.0f * Time.deltaTime));

		Vector3 velocity = GetComponent<Rigidbody> ().velocity;
		CheckLanded ();

		switch (step) {
		case STEP.RUN:
		case STEP.JUMP:
			if (transform.position.y < FAIL_LIMIT)
				next_step = STEP.MISS;
			break;

		}

		step_timer += Time.deltaTime;

		if (next_step == STEP.NONE) {
			switch (step) {
			case STEP.RUN:
		/*		if (!is_landed) {
				} else if (Input.GetMouseButtonDown (0))
					next_step = STEP.JUMP;
				break;
		*/
				velocity.x += player_move.ACCELEATION * Time.deltaTime;
				if (Mathf.Abs (velocity.x) > player_move.SPEED_MAX)
					velocity.x = player_move.SPEED_MAX;
				break;

			case STEP.JUMP:
				do{
					if(!Input.GetMouseButtonUp(0))
						break;
					if(is_key_released)
						break;
					if(velocity.y <= 0.0f)
					{
						velocity.x = 0.0f;
						Application.Quit();
					}
				/*
				if (is_landed)
					next_step = STEP.RUN;
				break;
				*/
			}
			while (next_step != STEP.NONE) {
				step = next_step;
				next_step = STEP.NONE;

				switch (step) {
				case STEP.JUMP:
					velocity.y = Mathf.Sqrt (2.0f * 9.8f * JUMP_HEIGHT_MAX);
					is_key_released = false;
					break;
				}

				step_timer = 0.0f;
			}
		}
	}

	private void CheckLanded()
	{
		is_landed = false;

		do {
			Vector3 current_position = transform.position;
			Vector3 down_position = current_position + Vector3.down * 0.1f;

			RaycastHit hit;
			if (!Physics.Linecast (current_position, down_position, out hit))
				break;

			if (step == STEP.JUMP) {
				if (step_timer < Time.deltaTime * 3.0f)
					break;
			}

			is_landed = true;
		} while(false);

	}
}
