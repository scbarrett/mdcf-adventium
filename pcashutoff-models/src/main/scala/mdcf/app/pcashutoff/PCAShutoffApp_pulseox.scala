/* ---------------------------------------------------------------------------+
   PCAShutoffApp_pulseox.scala - SpO2 requirements for an app configured system 
     involved with running, monitoring & shutting down a PCA infusion pump.

   Author: Stephen C. Barrett (scbarrett@ksu.edu)
           Department of Computing & Information Sciences
               
   Licensed Material - Property of Kansas State University.               
   ---------------------------------------------------------------------------+
   App is looking to obtain SpO2 physiological measures from an available
   device, which in the end-to-end scenario is a pulse oximeter.
   Note that the scenario requirements have been broken into three files.
   ---------------------------------------------------------------------------*/
package mdcf.app.pcashutoff

import edu.ksu.cis.santos.mdcf.dms._
import edu.ksu.cis.santos.mdcf.dms.examplev2.clas._
import edu.ksu.cis.santos.mdcf.dms.examplev2.schema._


trait PCAShutoffApp_pulseox extends ICE_APP_REQ 
{
  val spo2 : ICE_SpO2_Numeric 
  val spo2_get : ICE_Get_Exchange
  val spo2_per : ICE_Periodic_Exchange
}


object PCAShutoffApp_pulseox
{  
  @Inv val req_spo2_get : Predicate[PCAShutoffApp_pulseox] = pred 
  {
    req : PCAShutoffApp_pulseox => req.spo2 match 
    {              
      case spo2_ex : ICE_SpO2_Numeric => 
          spo2_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Get_Exchange => req.spo2_get == exch  
          case _ => false 
        }
      )
      case _ => false
    }
  }
  
  @Inv val req_spo2_per : Predicate[PCAShutoffApp_pulseox] = pred 
  {
    req : PCAShutoffApp_pulseox => req.spo2 match 
    {              
      case spo2_ex : ICE_SpO2_Numeric => 
          spo2_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Periodic_Exchange => req.spo2_per == exch  
          case _ => false 
        }
      ) 
    }
  }
}
