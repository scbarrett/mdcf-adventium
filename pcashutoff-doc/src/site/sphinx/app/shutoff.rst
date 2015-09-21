.. include:: ../util/substitution.rst


The PCA Shut-off Application
############################
The Integrated Clinical Environment is architected to be a "system of systems" 
of which the PCA Shut-off App is but one of many possible hosted systems. As a
program running on the 
|ICE| Supervisor---a reusable infrastructure component of the ICE---the App can
designate its needs and have the Supervisor pull together an *interoperable* 
system of medical devices for it, instead of cobbling together an ad hoc network 
of stand-alone devices on its own. By doing so, the App also gains input and 
output functionality through the Supervisor's user interface (SUI), and access 
to the ICE communication channels via transparent middleware.     

.. Why relevant, why this example?


PCA Shut-off App in Context
***************************
One conceivable instance of a system that the ICE Supervisor could construct, 
based of requirements given it by the PCA Shut-off App, is pictured here in
a clinical environment. 

.. figure:: images/system-context.png
    :alt: Instantiation app specified system
    :align: center
    
    ICE Instantiation of PCA Safety Interlock App with Context Interactions

The clinical context is delimited by an outermost *process boundary*. Besides
the ICE system, shown within the *system boundary*, it includes a clinician and 
a patient who both interact with the system: the clinician either through the 
Supervisor UI as configured by the App, or through the front panels of the PCA 
pump and monitoring devices; the patient through the pump's drug dispenser, and 
his physiological responses as sensed by the various monitors. Finally, the 
clinician and patient can be seen to interact with each other.


PCA Usage and Shut-off
======================
The shut-off system itself consists of the PCA Shut-off App, a suite of medical 
devices, and the ICE Data Logger. The Logger, which is fed data from the App, is 
for audit purposes, and need not be considered further. The App also interacts 
with the Device Suite: sending commands to the PCA Pump, and acquiring
physiological measurements from the monitors. It uses the SUI to display these
values along with results of any trend analyses, to set off alarms, and to 
summarize the state of alarm and infusion conditions.

The clinician sets up and initialized the system by running the PCA Shut-off
App, and entering operating values. These values specify things like enabling 
on-demand pump infusion, and setting dosage limits and alarm levels. Once 
attached to the device probes and sensors, the patient is given an actuator for
signaling desire of a bolus of opoid. A thread in the app process is responsible 
for detecting deteriorating respiratory health---a sign of possible drug 
overdose.

This monitoring algorithm uses the physiological measurments of blood oxygen
saturation (SpO2), End-Tidal carbon dioxide (EtCO2), and respiratory rate (RR) 
obtained by, in the illustrated system instance, pulse oximeter and 
capgnography devices. When values and/or trends for these physiological 
parameters indicate a possible onset of respiratory depression, the system
gives out audible and visual alarms. The condition for enunciating these alarms 
is referred to as the alarm condition.
 
Should respiratory health signs continue to deteriorate, the system safety 
interlock will be tripped, halting the pump's infusion. The condition for 
halting the pump in this manner is referred to as the halt condition.


Shut-off App as a Control Loop
==============================
An examination of the signals flowing between components in the context diagram
reveals many loops. It can be useful to view such as classical control loops. 
Especially where the PCA pump is involved, as in the loop below.

.. figure:: images/app-device-loop.png
    :alt: Loop of **app** to device control 
    :align: center
    
    Caption

Traveling counter-clockwise around the loop from the top

.. This is in anticipation of supporting |STPA| hazards analysis of such systems of interoperable components. 

Controller & Process Model
--------------------------
* App control & display
* process model

Actuator
--------
* PCA command port
* pump actuator (not from patient)

Controlled Process
------------------
* PCA pump
* patient

Sensors
-------
* Monitoring devices
* rr, spo2, etco2 feedback

