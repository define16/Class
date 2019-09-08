using System.Collections;

using System.Collections.Generic;

using UnityEngine;



public class ray_tracer : MonoBehaviour {

	private  List<GameObject> touch_list = new List<GameObject> ();

	private GameObject[] touch_prev;

	private RaycastHit hit; // 

	// Use this for initialization

	void Start () {



	}



	// Update is called once per frame

	void Update () {

		#if UNITY_EDITOR



		if(Input.GetMouseButton(0) || Input.GetMouseButtonDown(0) || Input.GetMouseButtonUp(0))

		{

			touch_prev = new GameObject[touch_list.Count];

			touch_list.CopyTo(touch_prev);

			touch_list.Clear();



			Ray ray = Camera.main.ScreenPointToRay(Input.mousePosition); // camera로 부터  컴퓨터 상의  Scene에서 mouse로 클릭 한 지점 까지 선을  그린다.

			Debug.DrawRay(ray.origin, ray.direction*10000, Color.cyan, 10, false);



			if(Physics.Raycast(ray, out hit)) {// hit : 부딪힌 물체가 있다면 그 물체를 리턴 시킨다.

				GameObject recipient = hit.transform.gameObject;

				touch_list.Add(recipient);

				if(Input.GetMouseButton(0))

					recipient.SendMessage("touchStay", hit.point, SendMessageOptions.DontRequireReceiver);

				if(Input.GetMouseButtonDown(0))

					recipient.SendMessage("touchBegan", hit.point, SendMessageOptions.DontRequireReceiver);



				if(Input.GetMouseButtonUp(0))

					recipient.SendMessage("touchEnded", hit.point, SendMessageOptions.DontRequireReceiver);



			}



			foreach (GameObject g in touch_prev){

				if(!touch_list.Contains(g))

					g.SendMessage("touchExit", hit.point, SendMessageOptions.DontRequireReceiver);

			}

		}



		#endif





		//터치 인식이  가능 한 디바이스	

		if (Input.touchCount > 0) {

			touch_prev = new GameObject[touch_list.Count];

			touch_list.CopyTo (touch_prev);

			touch_list.Clear ();



			foreach (Touch touch in Input.touches) {

				Ray ray = Camera.main.ScreenPointToRay (touch.position);



				if (Physics.Raycast (ray, out hit)) {

					GameObject recipient = hit.transform.gameObject;

					touch_list.Add (recipient);





					//SendMessageOptions.RequireReceiver 찾는 함수가 없을 경우 오류 메시지를 발생 시킨다.

					if (touch.phase == TouchPhase.Began) //TouchPhase는 터치스크린의 터치 상태

						recipient.SendMessage ("touchBegan", hit.point, SendMessageOptions.DontRequireReceiver);



					if (touch.phase == TouchPhase.Ended)

						recipient.SendMessage ("touchEnded", hit.point, SendMessageOptions.DontRequireReceiver);

					if (touch.phase == TouchPhase.Stationary || touch.phase == TouchPhase.Moved)

						recipient.SendMessage ("touchStay", hit.point, SendMessageOptions.DontRequireReceiver);

					if (touch.phase == TouchPhase.Canceled)

						recipient.SendMessage ("touchExit", hit.point, SendMessageOptions.DontRequireReceiver);

				}



				foreach (GameObject g in touch_prev) {

					if (!touch_list.Contains (g))

						g.SendMessage ("touchExit", hit.point, SendMessageOptions.DontRequireReceiver);

				}

			}

		}









	}

}

