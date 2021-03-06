.. include:: ../util/substitution.rst
.. _aadl_models:


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
    
Above can be seen five component blocks either contained by, or attached to,
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
**processors** have been defined, leaving the software 
components of the PCA Infusion System *unbound*.

The functionality and responsibilities to be carried out by the processes have 
been partitioned into thread **subcomponents**: three in the *logic process*, 
and two in the *display process*. A thread represents a sequence of executing 
code. Here, the threads are shown communicating between the processes, and 
with devices.

A **device** in AADL is a simple or complex abstraction of either an internal
or external component. They consist of only those characteristics necessary for
unambiguous representation and analysis. Such is the case with the devices of
the typed system diagram: instead of modeling actual medical devices, they 
specify only the interfaces of those devices the app is expecting to work with.
Further, the interfaces do not even have to correspond to real device
interfaces. The ICE platform is allowed to connect through its middleware, any
number of available devices that when combined, satisfy the app requirements. 
In this sense, the pictured device components are better thought of as *pseudo
devices*.

That being said, the system must, at some point, interact with *real* medical
devices; these too, can be modeled as component hierarchies with AADL. The 
upshot is that the AADL representation of the PCA Infusion System is comprised
of two broad types of models: those that describe the app itself, and those that
describe the devices it needs to use in order to accomplish its goals. Models of
each type are elaborated on in the subsections that follow.


The Medical App Models
======================
A graphical layout for components of the PCA Infusion System as created in the
open-source AADL tool platform, |OSATE2| is depicted below. The model is 
constructed from the PCA Shutoff App's point of view, basically looking outward 
from inside the app. Thus, the app "sees" the three *pseudo* medical devices
it is expecting to work with: a PCA pump, a pulse oximeter, and a capnography.
Whether it actually gets those specific devices is immaterial, what matters is
that whatever combination of devices it *does* get provides the expected
services through the expected interfaces.

.. figure:: images/system-aadl.png
    :alt: Instantiation of **app** AADL model 
    :align: center
    
    PCA Infusion System from Point of View of the Shutoff App 


Software Subcomponents
----------------------

PCAShutoffApp.aadl
^^^^^^^^^^^^^^^^^^

.. logic.aadl
.. ^^^^^^^^^^

.. display.aadl
.. ^^^^^^^^^^^^


Device Interfaces
-----------------
To coincide with the Shutoff App's expectation of interacting with three medical
devices, the interfaces for controlling the PCA pump and for obtaining the
required physiological measures comprise three separate models: one for each
pseudo device, and named accordingly.

Describe first in detail, give brief information for others...

PCAShutoffApp_pulseox.aadl
^^^^^^^^^^^^^^^^^^^^^^^^^^
This AADL package declares two communication *exchanges* for a pulse oximeter 
device through which the app expects to gather measurements of the patient's
peripheral capillary oxygen saturation (SpO\ :sub:`2`). The concept of an
exchange maps to AADL **ports**, which are structured to implement one of the
MDCF simple communication patterns (SCP) (see :ref:`comm_patterns`). A "get" 
exchange consisting of two AADL ports implements the *requester-responder* 
communication pattern, and is aperiodic in nature, while a "periodic" exchange
is the opposite, and implements a *publisher-subscriber* pattern.

.. literalinclude:: snippets/PCAShutoffApp_pulseox.aadl
    :language: aadl
    :linenos:

Note that in the case of the "get" exchange, bi-directional information has been 
constrained to flow through two uni-directional ports. This is because the type 
of information flowing is asymmetric with respect to direction, which cannot be
modeled in AADL in a general way.  




PCAShutoffApp_etco2.aadl
------------------------


PCAShutoffApp_pcastop.aadl
--------------------------


The Medical Device Models
=========================


.. **Medical device interfaces**    


.. **File Types**

.. * Device interfaces


.. **Generated File Types**

.. * Port payload types
.. * Eclipse project file
.. * Requirement matching XML (App doesn't interface correctly with generated models??)  


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
    