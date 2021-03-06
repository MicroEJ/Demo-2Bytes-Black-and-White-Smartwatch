/*
 * Java
 *
 * Copyright 2016 IS2T. All rights reserved.
 * Use of this source code is subject to license terms.
 */
package com.microej.demo.smartwatch;

import com.microej.demo.smartwatch.component.SmartWatch;
import com.microej.demo.smartwatch.utils.Constants;

import ej.animation.Animator;
import ej.components.dependencyinjection.ServiceLoaderFactory;
import ej.microui.MicroUI;
import ej.microui.display.Display;
import ej.mwt.Desktop;
import ej.mwt.Panel;

/**
 * Main application entry point.
 *
 */
public class SmartWatchApp {

	private static SmartWatchRobot robot;

	// Prevents initialization.
	private SmartWatchApp() {
	}

	/**
	 * Application entry point..
	 *
	 * @param args
	 *            not used.
	 */
	public static void main(String[] args) {
		// Start MicroUI.
		MicroUI.start();

		// Initialize UI
		ServiceLoaderFactory.getServiceLoader().getService(Animator.class).setPeriod(80);
		Display display = Display.getDefaultDisplay();
		Desktop desktop = new Desktop(display);
		SmartWatch smartWatch = new SmartWatch(Constants.DISPLAY_WIDTH, Constants.DISPLAY_HEIGHT);
		Panel mainPage = new Panel();
		mainPage.setWidget(smartWatch);

		robot = new SmartWatchRobot(smartWatch);
		robot.start();

		// Start Display.
		mainPage.show(desktop, true);
		ServiceLoaderFactory.getServiceLoader().getService(Animator.class).setPeriod(80);

		// Start Display.
		desktop.show();
	}

	/**
	 * Stops the smartwatch.
	 */
	public static void stop() {
		robot.stop();

	}
}