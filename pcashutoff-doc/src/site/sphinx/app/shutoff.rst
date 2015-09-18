.. include:: ../util/substitution.rst


The PCA Shut-off App
####################
The integrated system as specified by the *PCA Shut-off Application* is hosted 
on the |MDCF| medical application platform (**MAP**). The **app** and its 
medical devices interact through the transparent middleware of the platform in 
order to run, monitor, and in extreme cases, shut down a PCA pump being used by 
a patient for pain relief.

.. Why relevant, why this example?


Shut-off App in Context
***********************
.. figure:: images/system-context.png
    :alt: Instantiation app specified system
    :align: center
    
    ICE Instantiation of PCA Safety Interlock App with Context Interactions


PCA Usage and Shut-off
**********************
Detection of deteriorating respiratory health is based on monitoring of  blood 
oxygen saturation (SpO2), End-Tidal carbon dioxide (EtCO2), and respiratory rate 
(RR) physiological parameters. When values and/or trends for these physiological 
parameters indicate the possible the onset of respiratory depression, the system 
produces audible and visual alarms. The condition for enunciating the alarms is 
referred to as the alarm  condition. When respiratory health continues to 
deteriorate, the system implements a safety interlock by halting the pump's 
infusion. The condition for halting the pump is referred to as the halt 
condition.

Describe how the pump is used in normal operation, and the conditions under
which it would be shut off... (Reference the scenario??)


Shut-off App as a Control Loop
------------------------------
For purposes of explanation, system components are broken out in terms of a 
classic, closed control loop. This is in anticipation of supporting |STPA| 
hazards analysis of such systems of interoperable components. 

.. Goals of subsystems and ensuring safety

.. figure:: images/app-device-loop.png
    :alt: Loop of **app** to device control 
    :align: center
    
    Caption
   



Controller & Process Model
==========================
* App control & display

Actuator
========
* PCA command port

Controlled Process
==================
* PCA pump

Sensors
=======
* Monitoring devices
