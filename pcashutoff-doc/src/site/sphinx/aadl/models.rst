.. include:: ../util/substitution.rst


Modeling the PCA Shutoff App
############################

AADL

real-time, embedded systems with analysis capabilities.
hirearchy of systems


Components:
Application
Devices
Requirements

Subsections decompose the system into five classes of models...

Requirements

App is looking to exchange SpO2, EtCO2, pulse rate and respiration rate 
physiological metrics with the devices it is connected to. This package
contains requirements for pulse ox, capnography and PCA pump devices.

App is looking to exchange EtCO2 and respiration rate physiological metrics 
with a device it can connected to. This package contains only requirements 
concerning a capnography device.

App is looking to be able to shut down the PCA pump if need be. This package 
contains only requirements concerning a PCA pump. 

App is looking to exchange SpO2 physiological metric with a device it can 
connected to. This package contains only requirements concerning a pulse ox.


Generated File Types
********************

* Device interfaces
* Requirement matching XML
* Port payload types
* Eclipse project file


Medical Device Interfaces
*************************


Medical Application AADL
************************

logic.aadl ?
============

Structure and Rationale
-----------------------


display.aadl ?
==============

Structure and Rationale
-----------------------


Medical Device AADL
*******************


Medical App Requirements AADL
*****************************


PCAShutoffApp.aadl
==================

Structure and Rationale
-----------------------


PCAShutoffApp_pulseox.aadl
==========================

Structure and Rationale
-----------------------


PCAShutoffApp_capnog.aadl
=========================

Structure and Rationale
-----------------------

PCAShutoffApp_pcapump.aadl
==========================

Structure and Rationale
-----------------------


Port Payload Types
******************

Requirements (XML)
******************

Eclipse Project File
********************



Medical Device Interfaces    
-------------------------
Existence of pump with stop action, SpO2, EtCO2, respiration rate measures.
Pseudo devices
