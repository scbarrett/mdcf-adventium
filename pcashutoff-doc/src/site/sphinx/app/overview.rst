.. include:: ../util/substitution.rst


Overview of the PCA Shutoff App
###############################
The integrated system as specified by the *PCA Shuttoff Application* is hosted 
on the |MDCF| medical application platform (**MAP**). The **app** and its 
medical devices interact through the transparent middleware of the platform in 
order to run, monitor, and in extreme cases, shut down a PCA pump being used by 
a patient for pain relief.

.. System diagram
.. Why relevant, why this example?

PCA Usage and Shutoff
*********************
Describe how the pump is used in normal operation, and the conditions under
which it would be shut off... (Reference the scenario??)


The System as a Control Loop
****************************
.. Control loop diagram
.. Goals of subsystems and ensuring safety

For purposes of explanation, system components are broken out in terms of a 
classic, closed control loop. This is in anticipation of supporting |STPA| 
hazards analysis of such systems of interoperable components. 


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
