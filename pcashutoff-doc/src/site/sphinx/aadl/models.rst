.. include:: ../util/substitution.rst


Modeling the PCA Shutoff App
############################
The architectural analysis and design language (|AADL|) is used for modeling 
real-time, embedded systems in a component and connector architectural style as
a hierarchy of components. The language brings with it a number of analysis 
capabilities...


System Model Categories
***********************
The models that specify the app configured system can be divided into two broad 
classes: those that describe the app itself, and those that model the devices 
it interacts with to accomplish its goals. 


Medical App Models
==================

File Types
----------
* Device interfaces

Generated File Types
--------------------
* Port payload types
* Eclipse project file
* Requirement matching XML


Medical Device Models
=====================
The *Shutoff App* system obviously needs a PCA pump to control. The only 
capability beyond normal functionality it is required to possess, is a command
port through which a signal may shut it off.

In addition to the pump, the app requires these measures of patient 
physiological parameters: SpO2, EtCO2 and respiration rate. In the demo 
implementation of the *end-to-end scenario*, the first requirement is satisfied 
by a pulse oximeter device, and the remainder by a capnography device.


File Types
----------
* Devices


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
==================

Requirements (XML)
==================

Eclipse Project File
====================

Medical device interfaces    
-------------------------

Existence of pump with stop action, SpO2, EtCO2, respiration rate measures.
Pseudo devices
