using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class DateCheck : MonoBehaviour {
	System.DateTime now;

	int now_month;
	int now_day;
	// Use this for initialization
	void Start () {
		now = System.DateTime.Now;
		now_month = now.Month;
		now_day = now.Day;
		Debug.Log (now_month + "-" + now_day);
	}
	
	// Update is called once per frame
	void Update () {
		
	}
}
