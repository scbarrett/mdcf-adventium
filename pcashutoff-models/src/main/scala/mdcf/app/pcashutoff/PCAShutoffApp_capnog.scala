/* ---------------------------------------------------------------------------+
   PCAShutoffApp_capnog.scala - EtCO2 and respiratory rate requirements for an 
     app configured system involved with running, monitoring & shutting down a 
     PCA infusion pump.

   Author: Stephen C. Barrett (scbarrett@ksu.edu)
           Department of Computing & Information Sciences
               
   Licensed Material - Property of Kansas State University.               
   ---------------------------------------------------------------------------+
   App is looking to obtain EtCO2 and respiration rate physiological measures 
   from an available device, which in the end-to-end scenario is a capnography.
   Note that the scenario requirements have been broken into three files.
   ---------------------------------------------------------------------------*/
package mdcf.app.pcashutoff

import edu.ksu.cis.santos.mdcf.dms._
import edu.ksu.cis.santos.mdcf.dms.examplev2.clas._
import edu.ksu.cis.santos.mdcf.dms.examplev2.schema._


trait PCAShutoffApp_capnog extends ICE_APP_REQ 
{
  val etco2 : ICE_EtCo2_Numeric 
  val etco2_per : ICE_Periodic_Exchange

  val respire : ICE_RespiratoryRate_Numeric
  val respire_per : ICE_Periodic_Exchange
}


object PCAShutoffApp_capnog
{  
  @Inv val req_etco2_per : Predicate[PCAShutoffApp_capnog] = pred 
  {
    req : PCAShutoffApp_capnog => req.etco2 match 
    {              
      case etco2_ex : ICE_EtCo2_Numeric => 
          etco2_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Periodic_Exchange => req.etco2_per == exch  
          case _ => false 
        }
      ) 
      case _ => false
    }
  }

  
  @Inv val req_respire_per : Predicate[PCAShutoffApp_capnog] = pred 
  {
    req : PCAShutoffApp_capnog => req.respire match 
    {              
      case respire_ex : ICE_RespiratoryRate_Numeric => 
          respire_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Periodic_Exchange => req.respire_per == exch  
          case _ => false 
        }
      ) 
      case _ => false
    }
  }
}
