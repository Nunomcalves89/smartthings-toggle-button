/**
 *  Copyright 2015 SmartThings
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License. You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed
 *  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License
 *  for the specific language governing permissions and limitations under the License.
 *
 *  Simulated Toggle Button
 *
 *  Author: SBDOBRESCU
 *
 *  Date: 2015-11-13
 */
 
metadata {
	definition(author: "Bobby Dobrescu", name: "Simulated Toggle Button", namespace: "Home Automation") {
		capability("Actuator")
		capability("Switch")
		capability("Sensor")
	}

	// UI tile definitions
	tiles {
		standardTile("button", "device.switch", canChangeIcon: true, height: 2, width: 2) {
			state("off", action: "switch.on",  backgroundColor: "#ffffff", icon: "st.switches.switch.off", label: "Off", nextState: "on")
			state("on",  action: "switch.off", backgroundColor: "#79b821", icon: "st.switches.switch.on",  label: "On",  nextState: "off")
		}
		
		details("button")
        main("button")
	}
}

def on() { 
	push() 

}
def off() { 
	push() 
}

def push() { 
	def toggleState = device.currentState("switch")?.value
	
    sendEvent(display: false, isStateChange: true, name: "switch", value: (toggleState == "on") ? "off" : "on")
	sendEvent(display: false, displayed: false, name: "momentary", value: "pushed")
}
