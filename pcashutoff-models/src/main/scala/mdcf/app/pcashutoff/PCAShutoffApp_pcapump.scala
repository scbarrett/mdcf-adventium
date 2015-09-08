/* ---------------------------------------------------------------------------+
   PCAShutoffApp_pcapump.scala - Pump requirements for an app configured system 
     involved with running, monitoring & shutting down a PCA infusion pump. 

   Author: Stephen C. Barrett (scbarrett@ksu.edu)
           Department of Computing & Information Sciences
               
   Licensed Material - Property of Kansas State University.               
   ---------------------------------------------------------------------------+
   App is looking to connect to a PCA infusion pump, which it is capable of 
   shutting down, if need be.
   Note that the scenario requirements have been broken into three files.
   ---------------------------------------------------------------------------*/
package mdcf.app.pcashutoff
import edu.ksu.cis.santos.mdcf.dms._
import edu.ksu.cis.santos.mdcf.dms.examplev2.clas._
import edu.ksu.cis.santos.mdcf.dms.examplev2.schema._


trait PCAShutoffApp_pcapump extends ICE_APP_REQ 
{
  val stop : ICE_PCAF_Stop_Action
  val stop_act : ICE_Action_Exchange
}


object PCAShutoffApp_pcapump
{  
  @Inv val req_stop_act : Predicate[PCAShutoffApp_pcapump] = pred 
  {
    req : PCAShutoffApp_pcapump => req.stop match 
    {              
      case stop_ex : ICE_PCAF_Stop_Action => 
          stop_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Action_Exchange => req.stop_act == exch  
          case _ => false 
        }
      )
      case _ => false
    }
  }
}
