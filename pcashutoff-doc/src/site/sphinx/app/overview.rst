.. include:: ../util/substitution.rst


Overview of the PCA Shutoff App
###############################
The system as configured by the *PCA Shuttoff Application* is hosted on the
|MDCF| medical application platform (**MAP**). The **app** and its medical 
devices interact through the transparent middleware of the platform in order to 
run, monitor, and in extreme cases, shut down a PCA pump being used to relief 
patient pain.


PCA Usage and Shutoff
*********************
Describe how the pump is used in normal operation, and the conditions under
which it would be shut off...  


The System as a Control Loop
****************************
In anticipation of supporting |STPA| hazards analysis, we break out system 
components in terms of a classic, closed control loop...

Controller & Process Model
==========================

App control & display
-----------------------

Actuator
========

PCA command port
----------------

Controlled Process
==================

PCA pump
--------

Sensors
=======

Monitoring devices
------------------
