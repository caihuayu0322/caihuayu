package com.incito.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class jan27 {

	public static void main(String[] args) {
		Timer timer = new Timer();
		TimerTask timerTasker = new TimerTask() {
			
			int i = 0;
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(i++);
			}
		};
		timer.schedule(timerTasker, System.currentTimeMillis());
		timer.cancel();
	}
}
