/* ---------------------------------------------------------------------------+
   PCAShutoffApp.scala - All requirements for an app configured system involved 
     with running, monitoring & shutting down a PCA infusion pump.

   Author: Stephen C. Barrett (scbarrett@ksu.edu)
           Department of Computing & Information Sciences
               
   Licensed Material - Property of Kansas State University.               
   ---------------------------------------------------------------------------+
   App is looking to obtain SpO2, EtCO2 and respiration rate physiological 
   metrics from devices, and to connect to a PCA infusion pump, which it is 
   capable of shutting down, if need be.
   Note that all the scenario requirements are contained in this file.
   ---------------------------------------------------------------------------*/
package mdcf.app.pcashutoff_single
import edu.ksu.cis.santos.mdcf.dms._
import edu.ksu.cis.santos.mdcf.dms.examplev2.clas._
import edu.ksu.cis.santos.mdcf.dms.examplev2.schema._


trait PCAShutoffApp_single extends ICE_APP_REQ 
{
  val etco2 : ICE_EtCo2_Numeric 
  val etco2_get : ICE_Get_Exchange
  val etco2_per : ICE_Periodic_Exchange

  val respire : ICE_RespiratoryRate_Numeric
  val respire_get : ICE_Get_Exchange
  val respire_per : ICE_Periodic_Exchange
  
  val spo2 : ICE_SpO2_Numeric 
  val spo2_get : ICE_Get_Exchange
  val spo2_per : ICE_Periodic_Exchange
  
  val stop : ICE_PCAF_Stop_Action
  val stop_act : ICE_Action_Exchange
}


object PCAShutoffApp_single
{  
  @Inv val req_etco2_get : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.etco2 match 
    {              
      case etco2_ex : ICE_EtCo2_Numeric => 
          etco2_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Get_Exchange => req.etco2_get == exch  
          case _ => false 
        }
      )
      case _ => false
    }
  }

  @Inv val req_etco2_per : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.etco2 match 
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

  
  @Inv val req_respire_get : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.respire match 
    {              
      case respire_ex : ICE_RespiratoryRate_Numeric => 
          respire_ex.exchanges.values.exists(  
        _ match 
        {                                                      
          case exch : ICE_Get_Exchange => req.respire_get == exch  
          case _ => false 
        }
      ) 
      case _ => false
    }
  }

  @Inv val req_respire_per : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.respire match 
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
  
  
  @Inv val req_spo2_get : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.spo2 match 
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
  
  @Inv val req_spo2_per : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.spo2 match 
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


  @Inv val req_stop_act : Predicate[PCAShutoffApp_single] = pred 
  {
    req : PCAShutoffApp_single => req.stop match 
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
