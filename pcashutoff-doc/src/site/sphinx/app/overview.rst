.. include:: ../util/substitution.rst


Overview of the PCA Shutoff App
###############################
The system as configured by the *PCA Shuttoff Application* is hosted on the
|MDCF| medical application platform (**MAP**). The **app** and its medical 
devices interact through the transparent middleware of the platform in order to 
run, monitor, and in extreme cases, shut down a PCA pump under its 
control being used to relief patient pain.


PCA Usage and Shutoff
*********************
Describe how the pump is used in normal operation, and the shutoff scenario...  


Components of the System
************************
Break out components in terms of a classic closed control loop...

App Control and Display
=======================
loop: controller & process model

PCA Stop Port
=============
loop: actuator

PCA Pump
========
loop: controlled process

Monitoring Devices
==================
loop: sensors
