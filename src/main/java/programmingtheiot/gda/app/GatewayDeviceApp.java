/**
 * This class is part of the Programming the Internet of Things
 * project, and is available via the MIT License, which can be
 * found in the LICENSE file at the top level of this repository.
 * 
 * You may find it more helpful to your design to adjust the
 * functionality, constants and interfaces (if there are any)
 * provided within in order to meet the needs of your specific
 * Programming the Internet of Things project.
 */

package programmingtheiot.gda.app;

import org.apache.commons.cli.*;

import programmingtheiot.common.ConfigConst;
import programmingtheiot.common.ConfigUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import programmingtheiot.gda.system.SystemPerformanceManager;

/**
 * Main GDA application.
 * 
 */
public class GatewayDeviceApp
{
	// static
	
	private static final Logger _Logger =
		Logger.getLogger(GatewayDeviceApp.class.getName());
	
	public static final long DEFAULT_TEST_RUNTIME = 60000L;
	
	// private var's
	
	private String configFile = ConfigConst.DEFAULT_CONFIG_FILE_NAME;

	private SystemPerformanceManager sysPerfMgr = null;

	// constructors
	
	/**
	 * Default.
	 * 
	 * @param configFile
	 */
	public GatewayDeviceApp()
	{
		super();
		
		_Logger.info("Initializing GDA...");

		this.sysPerfMgr = new SystemPerformanceManager();
	}

	public GatewayDeviceApp(String[] args)
	{
		super();
	
		_Logger.info("Initializing GDA...");
		
		this.sysPerfMgr = new SystemPerformanceManager();

		parseArgs(args);
	}
	
	// static
	
	/**
	 * Main application entry point.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		GatewayDeviceApp gwApp = new GatewayDeviceApp(args);
	
		gwApp.startApp();
		
		try {
			Thread.sleep(65000L);
		} catch (InterruptedException e) {
			// ignore
		}
		
		gwApp.stopApp(0);
	}
	
	// public methods
	
	/**
	 * Initializes and starts the application.
	 * 
	 */
	public void startApp()
	{
		_Logger.info("Starting GDA...");
		try{
			if (this.sysPerfMgr.startManager()) {
			_Logger.info("GDA started successfully.");
		} else {
			_Logger.warning("Failed to start system performance manager!");
			
			stopApp(-1);
		}
		}catch(Exception e){
			_Logger.info(""+e);
			stopApp(-1);
		}
	}
	
	/**
	 * Stops the application.
	 * 
	 * @param code The exit code to pass to {@link System.exit()}
	 */
	public void stopApp(int code)
	{
		try{
			if (this.sysPerfMgr.stopManager()) {
			_Logger.log(Level.INFO, "GDA stopped successfully with exit code {0}.", code);
		} else {
			_Logger.warning("Failed to stop system performance manager!");
		}
		}catch(Exception e){
			_Logger.info(""+e);
		}
		_Logger.info("Punkrocker yes I am: "+code);
	}
	
	
	// private methods
	private void initConfig(String fileName){
		_Logger.info("initConfig not exist yet");
	}

	private void parseArgs(String[] args){
		initConfig(null);
		_Logger.info("parseArgs not exist yet");
	}

}
