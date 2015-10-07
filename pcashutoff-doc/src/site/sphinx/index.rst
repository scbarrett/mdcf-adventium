.. MDCF PCA Shutoff App documentation master file, created by
   sphinx-quickstart on Tue Sep  1 14:24:42 2015.
   Adapt as desired, but keep the root `toctree` directive.

.. include:: util/substitution.rst
.. _home_page:


##########################################
Documentation for the MDCF PCA Shutoff App
##########################################
:author:       `Steve Barrett <http://people.cis.ksu.edu/~scbarrett>`_
:contact:      scbarrett@ksu.edu
:organization: `SAnToS Laboratory <http://santoslab.org>`_, `Kansas State University <http://k-state.edu>`_
:last updated: |today| (`changes <https://github.com/scbarrett/mdcf-adventium/commits/master>`_)


**********************************************************
A PCA Infusion System with Safety Monitoring and Interlock
**********************************************************
A patient controlled analgesia (PCA) infusion pump is a medical device used in 
clinical settings for the on-demand, infused delivery of a pain relieving opioid 
to a patient. Security concerns over misuse, and safety concerns over the 
possibility of overdose motivate this specification of a system for monitoring 
PCA pump operation, and, if need be, shutting the pump off by way of an 
interlock mechanism.

Such a system would provide clinicians wanting to use a PCA pump for patient
pain relief with a central point for issuing commands and gathering feedback.
Once attached, the system would continuously acquire and analyze patient
physiological parameters so as to detect any sign of deteriorating respiratory 
health that might indicate an overdose situation.


Interoperable Clinical System Development 
=========================================
The construction of a simplified version of the PCA Monitoring and Safety 
Interlock System, along with automated tools to support its development, has 
been undertaken by the SAnToS group at Kansas State University. The goal is to 
realize the end-to-end development of an interoperable system of medical devices 
involving a PCA pump, which the system will be capable of shutting off.

This so-called, *PCA Shutoff App* scenario is based on the Integrated Clinical 
Environment (|ICE|) functional model. In the scenario, an ICE compliant 
application, or **app**, running on a managed ICE infrastructure (*e.g.*, the
|MDCF|, at KSU) specifies the configuration of an integrated system comprised of
ICE compliant medical devices. Here is an overview: 

.. figure:: images/system-overview.png
    :alt: App specified system
    :align: center

    An Integrated Clinical System as Specified by the Shutoff App

Because it is the component that specifies just what capabilities the resulting 
integrated system must have, the application is at the heart of the system.
Satisfying its requirements results in the inclusion of the various controlled
and monitoring devices seen along the bottom of the diagram. A supervising UI, 
internal to the app, that permits interaction with the clinician completes the
system.


Contents:
*********
.. toctree::
   :maxdepth: 3

   app/shutoff
   aadl/models
   comm/patterns


..
   Indices and Tables
   ==================
   * :ref:`genindex`
   * :ref:`search`


.. admonition:: Acknowledgements
   
   The development of the |PCA Shutoff| is supported in part by ??
    
   Any opinions, findings, and conclusions or recommendations expressed in this material are those of the author(s) and do not necessarily reflect the views of the previously mentioned institutions.

.. admonition:: License

   This work is licensed under the |EPL|.
