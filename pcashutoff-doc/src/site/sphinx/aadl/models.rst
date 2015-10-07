.. include:: ../util/substitution.rst


################################
Modeling the PCA Infusion System
################################
Models are a powerful way of designing a system and conveying its structure. 
An expressive modeling language can provide the means for analyzing a system as
its design evolves. One language that is expressive and precise enough to do so
is the Architectural Analysis and Design Language.

|AADL| is meant for modeling real-time, embedded systems. The language supports 
the specification of data, control, and error flows, as well as descriptions of 
discrete and continuous behaviors. AADL, along with extending **annexes**, 
brings with it model analysis and simulation capabilities. This section explores 
the AADL models of the PCA Infusion System.


*****************************
The System and its Components 
*****************************
AADL uses a combination of the *module* and *component-and-connector* (C&C) 
architectural viewtypes to represent a system. With a **component** being one of
the principle processing units of the executing system, and a **connector** 
being a mechanism by which these components interact. The module *decomposition
style* goes on to reveal the hierarchical nature of the *attached* components
through its use of *containment*.  

.. figure:: images/app-comps&props(type).png
    :alt: Declaration of app 
    :align: center

    Structure of the PCA Infusion System
    
Above can be seen five component blocks either contained by, or attached to
other components with communication links over which they can interact. The
yellow labels give an idea of the intended purpose of the boxes and their
connections. They also allude to the notion of characterizing elements with
properties.

    
The System Expressed in AADL
============================
The ambiguous boxes and arrows of the preceding diagram have been typed below
with AADL component categories, thus giving them meaningful semantics. Some
concrete properties are shown as having been added as well.

.. figure:: images/app-comps&props(inst).png
    :alt: Instantiation of app 
    :align: center

    Typed and Characterized Elements of the PCA Infusion System
    
The figure identifies the two labeled "software components" as processes. That 
is, as memory address spaces representing compiled code and data that are 
protected at runtime. **Processes**, **threads**, and **data** are the principle
runtime software abstractions in AADL. Note that our design does not yet need
to concern itself with platform issues, so no system **memory** or
**processors** have been defined, leaving the PCA Infusion System's software 
components *unbound*.

The functionality and responsibilities required of the processes have been 
partitioned into thread **subcomponents**: three in the *logic process*, and two 
in the *display process*. A thread represents a sequence of executing code. 
Here, the threads are shown as communicating between the processes, and with 
devices.

A **device** in AADL is a simple or complex abstraction of either an internal
or external component. They consist of only those characteristics necessary for
analysis and unambiguous representation. Such is the case with the devices of
the typed system diagram: instead of modeling actual medical devices, they 
specify only the interface of those devices the App is expecting to work with.
Further, the interfaces do not even have to correspond to real device
interfaces. In order to satisfy the App requirements, the ICE platform is
allowed to connect, through its middleware, to any number of available devices.
In this sense, the pictured device components are better thought of as *pseudo
devices*.

That being said, the system must, at some point, interact with *real* medical
devices; these too, can be modeled with AADL as component hierarchies. The 
upshot is that the PCA Infusion System is comprised of two broad types of
models: those that describe the app itself, and those that represent the devices
it needs to accomplish its goals. The following subsections elaborate on each
type.


The Medical App AADL Model
==========================
The Shutoff App interfaces with three *pseudo* medical devices: a PCA pump, a 
pulse oximeter, and a capnography. The AADL models that specify all these 
components are described in this section.

.. figure:: images/system-aadl.png
    :alt: Instantiation of **app** AADL model 
    :align: center
    
    PCA Infusion System from Point of View of the Shutoff App 




PCAShutoffApp.aadl
------------------
**Structure and Rationale**

logic.aadl
^^^^^^^^^^

display.aadl
^^^^^^^^^^^^


Pseudo Medical Devices
^^^^^^^^^^^^^^^^^^^^^^
**Medical device interfaces**    


.. **File Types**

.. * Device interfaces


.. **Generated File Types**

.. * Port payload types
.. * Eclipse project file
.. * Requirement matching XML (App doesn't interface correctly with generated models??)  


Medical Device Models
^^^^^^^^^^^^^^^^^^^^^
.. Strictly speaking, needs the interfaces...
.. (App requirements and device matching??)

.. (Generated files??)

.. The *Shutoff App* system obviously needs a PCA pump to control. The only 
.. capability beyond normal functionality it is required to possess, is a command
.. port through which a signal may shut it off.

.. In addition to the pump, the app requires these measures of patient 
.. physiological parameters: SpO2, EtCO2 and respiration rate. In the demo 
.. implementation of the *end-to-end scenario*, the first requirement is satisfied 
.. by a pulse oximeter device, and the remainder by a capnography device.


.. **File Types**

.. * Devices


PCAShutoffApp_spo2.aadl
==========================
**Structure and Rationale**

.. literalinclude:: snippets/PCAShutoffApp_spo2.aadl
    :language: aadl
..    :linenos:



PCAShutoffApp_etco2.aadl
=========================
**Structure and Rationale**


PCAShutoffApp_pcastop.aadl
==========================
**Structure and Rationale**


.. Port Payload Types
.. ==================

.. Requirements (XML)
.. ==================

.. Eclipse Project File
.. ====================

.. .. literalinclude:: snippets/PCAShutoffApp.project
.. ..    :language: xml
..    :linenos:


.. Existence of pump with stop action, SpO2, EtCO2, respiration rate measures.
.. Pseudo devices


.. .. literalinclude:: snippets/PCAShutoffApp_Types.aadl
.. ..    :language: aadl
..    :linenos:


.. .. literalinclude:: snippets/PCAShutoffApp_spo2.req.xml
.. ..    :language: xml
..    :linenos:
    